function loadHome() {
	var uid = document.getElementById("uid");
	//清除mgroup下的元素
	dwr.util.removeAllRows("mgroup");

	Page.homePage(function(moodList) {
		document.getElementById("mgroup").innerHTML = "";
			
		var mids = new Array()
		//将Page.homePage返回的信息循环添加至mgroup下
		for(var i = 0; i < moodList.length; i++) {
			mood = moodList[i];

			var item = document.createElement("div");
			item.className = "list-group-item";

			var head4 = document.createElement("h4");
			head4.innerHTML = mood.subject;
			head4.className = "list-group-item-heading";
			item.appendChild(head4);

			var passage = document.createElement("p");
			passage.innerHTML = mood.body;
			passage.className = "list-group-item-text";
			item.appendChild(passage);

			var divide = document.createElement("div");
			divide.align = "right";

			var btn = document.createElement("button");
			btn.innerHTML = "@";
			btn.id = mood.mid;
			mids[i] = btn.id;
			//关注按钮的默认值为“未关注”
			btn.className = "btn btn-xs btn-default";
			//模拟登录情况，未登录时，关注按钮不可点击
			if (uid.value != "") 
				btn.disabled = false;
			else
				btn.disabled = true;
			btn.onclick = function() {
				refresh(this.id);
			};

			divide.appendChild(btn);

			item.appendChild(divide);

			document.getElementById("mgroup").appendChild(item);
		}
			
		if (uid.value != "") {
			//Refresh.isFollower返回当前用户对列表中各子元素的关注情况
			Refresh.isFollower(uid.value, mids, function(bs) {
				for(var j = 0; j < bs.length; j++) {
					//用户已关注某子元素，将对应关注按钮的值修改为“已关注”
					if(bs[j] == true)
						document.getElementById(mids[j]).className = "btn btn-xs btn-success";
				}
			});
		}	

	});

}

function refresh(mid) {
	var uid = document.getElementById("uid");
	var mood = document.getElementById(mid);
	
	// 由于关注按钮的值由后台返回的信息确定
	// 所以关注按钮的值可以作为用户是否关注的依据
	// 不需要再次访问后台数据
	
	// 修改用户对某子元素的关注情况
	if (mood.className == "btn btn-xs btn-default") {
		Refresh.follow(uid.value, mood.id);
		mood.className = "btn btn-xs btn-success";
		Page.showLog(function(log) {
			document.getElementById("log").innerHTML = "";
			document.getElementById("log").innerHTML = log;
		});
	} else {
		Refresh.cancel(uid.value, mood.id);
		mood.className = "btn btn-xs btn-default";
		Page.showLog(function(log) {
			document.getElementById("log").innerHTML = "";
			document.getElementById("log").innerHTML = log;
		});
	}
}