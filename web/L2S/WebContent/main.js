function showl2s() {
	var xmlhttp;
	var lurl = document.getElementById("lurl").value;
	if (lurl == "") {
		document.getElementById("surl").innerHTML = "Enter the Long URL.";
		return;
	}
	
	var reg = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
	if (!reg.test(lurl)) {
		document.getElementById("surl").innerHTML = "Not a Valid URL.";
		return;
	}
	
	var reg = /^http:\/\/jemoii.duapp.com\/L2S\/*/;
	if (reg.test(lurl)) {
		document.getElementById("surl").innerHTML = "Not Allowed.";
		return;
	}

	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			var obj = eval("(" + xmlhttp.responseText + ")");
			document.getElementById("surl").innerHTML = "http://voler.me/"
					+ obj.path;
		}
	}

	xmlhttp.open("POST", "shorten.do", true);
	xmlhttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlhttp.send("luri=" + lurl);

}