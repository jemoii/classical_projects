<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/examples/theme/theme.css"
	rel="stylesheet">
<script src="login-verify.js"></script>
</head>
<body>
	<!--已登录，不再显示登录界面-->
	<c:choose>
		<c:when test="${sessionScope.uid != null}">
			<div class="alert alert-info" role="alert">
				<h2>
					<span class="label label-success">${sessionScope.uid}</span>已登录&nbsp;<a
						href="index.jsp"><input type="button" class="btn btn-info"
						value="点击跳转" /></a>
				</h2>
			</div>
		</c:when>
		<c:otherwise>
			<div class="page-header">
				<h2>登录账号</h2>
			</div>
			<div class="col-md-4">
				<table class="table">
				<tbody>
					<tr>
						<td><span class="label label-default">邮箱</span></td>
						<td colspan="2"><input type="text" id="uid" autofocus
							size="40" /></td>
						<td><span class="label label-warning" id="uid_tip"></span></td>
					</tr>
					<tr>
						<td><span class="label label-default">密码</span></td>
						<td colspan="2"><input type="password" id="password"
							size="40" /></td>
						<td><span class="label label-warning" id="password_tip"></span></td>
					</tr>
					<tr>
						<td></td>
						<td align="left"><input type="submit" class="btn btn-info"
							id="login" onclick="verify()" value="登录" /></td>
						<td align="left"><a href="register.html"><input
							type="button" class="btn btn-info" id="register" value="注册" /></a></td>
					</tr>
					<tr>
						<td colspan="3" rowspan="4"><div class="alert alert-info"
							role="alert"><strong>提示！</strong>&nbsp;
						</div></td>
					</tr>
				</tbody>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>