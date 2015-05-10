package me.l2s.web.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.l2s.jedis.P2T;

public final class ViceService implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getRequestURI().substring(
				5);
		if (path != null) {
			if (P2T.check(path) != null) {
				((HttpServletResponse) response).sendRedirect(P2T.check(path));
				return;
			} else if (!path.equals("main.html") && !path.equals("main.css")
					&& !path.equals("main.js") && !path.equals("shorten.do")
					&& !path.equals("")) {

				PrintWriter out = response.getWriter();
				out.print("<!DOCTYPE html>" + "<html>" + "<head>"
						+ "<meta charset=\"UTF-8\">"
						+ "<link rel=\"stylesheet\" href=\"main.css\" />"
						+ "<title>404</title>" + "</head>" + "<body>"
						+ "<header>" + "<hgroup>" + "<h2>404 Not Found</h2>"
						+ "<h3>This Shorted URL has not been generated.</h3>"
						+ "</hgroup>" + "</header>" + "</body>" + "</html>");
				out.flush();
				return;
			}
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
