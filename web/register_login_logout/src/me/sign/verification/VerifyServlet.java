package me.sign.verification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyServlet extends HttpServlet {

	private static final long serialVersionUID = 168763164316L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String uid = request.getParameter("uid");

		response.setContentType("text/html");
		//判断邮箱是否被注册
		if (VerifyService.service(uid))
			response.getWriter().write("true");
		else
			response.getWriter().write("false");

	}
}
