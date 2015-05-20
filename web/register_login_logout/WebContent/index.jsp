<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>主界面</title>
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="http://getbootstrap.com/examples/theme/theme.css"
	rel="stylesheet">
<script src="login-verify.js"></script>
</head>
<body>

	<div class="col-md-4">
		<table class="table">
			<tbody>
				<tr>
					<td colspan="3"><div class="alert alert-info" role="alert">
							<c:choose>
								<!--已登录-->
								<c:when test="${sessionScope.uid != null}">
									<form method="POST" action="logout.do">
										<h2>
											<span class="label label-success">${sessionScope.uid}</span>&nbsp;<input
												type="submit" class="btn btn-info" id="logout" value="注销" />
										</h2>
									</form>
								</c:when>
								<!--未登录-->
								<c:otherwise>
									<a href="login.jsp"><input type="button"
										class="btn btn-info" id="login" value="登录" /></a>
									<a href="register.html"><input type="button"
										class="btn btn-info" id="register" value="注册" /></a>
								</c:otherwise>
							</c:choose>
						</div></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>