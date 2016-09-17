function verify() {
	var xmlhttp;
	var uid = document.getElementById("uid");
	var password = document.getElementById("password");
	
	// 清除旧的验证结果
	document.getElementById("uid_tip").innerHTML = "";
	document.getElementById("password_tip").innerHTML = "";
	
	// 判断邮箱输入是否为空
	if(uid.value == "") {
		document.getElementById("uid_tip").innerHTML = "邮箱不能为空！";
		return;
	}
	var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	// 判断邮箱输入是否有效
	if (!reg.test(uid.value)) {
		document.getElementById("uid_tip").innerHTML = "邮箱格式不合法！";
		return;
	}
	// 判断密码输入是否为空
	if(password.value == "") {
		document.getElementById("password_tip").innerHTML = "密码不能为空！";
		return;
	}
	
	// Ajax
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	document.getElementById("uid_tip").innerHTML = "邮箱或密码错误！";
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if(xmlhttp.responseText == "false") {				
				document.getElementById("uid_tip").innerHTML = "邮箱或密码错误！";
			}
			// 登录成功，重定向至首页
			else {
				location.href="index.jsp";
			}
			
		}
	}

	xmlhttp.open("POST", "login.do", true);
	xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlhttp.send("uid=" + uid.value + "&key=" + password.value);
}