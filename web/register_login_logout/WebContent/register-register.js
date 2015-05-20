function register() {
	var xmlhttp;
	var uid = document.getElementById("uid");
	var verify = document.getElementById("verify");
	var password = document.getElementById("password");
	var affirm = document.getElementById("affirm");
	var verification = document.getElementById("verification");

	// 清除旧的验证结果
	document.getElementById("uid_tip").innerHTML = "";
	document.getElementById("verify_tip").innerHTML = "";
	document.getElementById("affirm_tip").innerHTML = "";

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
	// 判断验证码输入是否为空
	if (verification.value == "") {
		document.getElementById("verify_tip").innerHTML = "验证码不能为空！";
		return;
	}
	// 判断密码输入是否为空
	if (password.value == "" || affirm.value == "") {
		document.getElementById("affirm_tip").innerHTML = "密码不能为空！";
		return;
	}
	// 判断确认密码是否有效
	if (affirm.value != password.value) {
		document.getElementById("affirm_tip").innerHTML = "两次输入的密码不同！";
		return;
	}

	register_wait();

	// Ajax
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if (xmlhttp.responseText == "false") {
				// 验证码错误，重新获取验证码
				document.getElementById("verify_tip").innerHTML = "重新获取验证码！";
				uid.disabled = true;
				// 解锁获取按钮
				verify.disabled = false;
				password.disabled = true;
				affirm.disabled = true;
			}
			else {
				document.getElementById("verify_tip").innerHTML = "注册成功";
			}
		}
	}

	xmlhttp.open("POST", "register.do", true);
	xmlhttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlhttp.send("uid=" + uid.value + "&key=" + password.value + "&token="
			+ verification.value);
}

// 注册失败，等待10秒
var wait = 1;
function register_wait() {
	var button = document.getElementById("register");
	button.disabled = true;
	if (wait % 10 == 0) {
		button.disabled = false;
		button.value = "注册";
		wait++;
	} else {
		button.value = "等待 " + (10 - wait % 10) + " s";
		wait++;
		window.setTimeout("register_wait()", 1000);
	}
}