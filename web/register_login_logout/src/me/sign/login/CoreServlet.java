package me.sign.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CoreServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//获取登录邮箱及密码
		String uid = request.getParameter("uid");
		String key = request.getParameter("key");
		
		/**验证方法有待补充*/
		//验证通过，登录成功
		if (User.retrieve(uid, key)) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10 * 60);
			//将uid添加到会话属性
			session.setAttribute("uid", uid);
			Cookie cookie = new Cookie("uid", uid);
			response.addCookie(cookie);
			response.getWriter().write("true");
		//未通过验证
		} else {
			response.getWriter().write("false");
		}
	}
}
