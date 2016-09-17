function verify() {
	var xmlhttp;
	var uid = document.getElementById("uid");
	var verify = document.getElementById("verify");
	var register = document.getElementById("register");

	// 清除旧的验证结果
	document.getElementById("uid_tip").innerHTML = "";
	document.getElementById("verify_tip").innerHTML = "";

	// 判断邮箱输入是否为空
	if (uid.value == "") {
		document.getElementById("uid_tip").innerHTML = "邮箱不能为空！";
		return;
	}
	var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	// 判断邮箱输入是否有效
	if (!reg.test(uid.value)) {
		document.getElementById("uid_tip").innerHTML = "邮箱格式不合法！";
		return;
	}

	update();

	// Ajax
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if (xmlhttp.responseText == "true") {
				// 邮箱未注册，锁定邮箱，锁定获取按钮
				document.getElementById("verify_tip").innerHTML = "查看邮件，填写验证码";
				uid.disabled = true;
				verify.disabled = true;
				register.disabled = false;
			} else {
				// 邮箱已注册，重新获取验证码
				document.getElementById("uid_tip").innerHTML = "邮箱已注册！";
				register.disabled = true;
			}
		}
	}

	xmlhttp.open("POST", "verify.do", true);
	xmlhttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlhttp.send("uid=" + uid.value);
}

// 30秒后再次获取验证码
var count = 1;
function update() {
	var button = document.getElementById("verify");
	button.disabled = true;
	if (count % 30 == 0) {
		button.disabled = false;
		button.value = "获取验证码";
		count++;
	} else {
		button.value = "等待 " + (30 - count % 30) + " s";
		count++;
		window.setTimeout("update()", 1000);
	}
}