package me.l2s.web.v;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.l2s.web.c.CoreService;

public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 6608779840346489313L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String luri = request.getParameter("luri");
		String json = CoreService.service(luri);

		response.setContentType("text/html");
		response.getWriter().write(json);

	}
}
