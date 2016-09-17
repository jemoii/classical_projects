package me.voler.classical.register_login_logout.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 168763546316L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String uid = request.getParameter("uid");
		String code = request.getParameter("token");
		String key = request.getParameter("key");

		response.setContentType("text/html");
		//验证验证码，判断注册是否成功
		if (RegisterService.service(uid, code, key))
			response.getWriter().write("true");
		else
			response.getWriter().write("false");

	}
}
