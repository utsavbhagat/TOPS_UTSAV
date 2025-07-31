package example;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletResponse;

public class ValidationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");

		if (username == null || username.trim().isEmpty() || email == null || email.trim().isEmpty()) {
			((HttpServletResponse) response).sendRedirect("UserForm.jsp?error=true");
		} else {
			chain.doFilter(request, response); // Input is valid, continue
		}
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}
}
