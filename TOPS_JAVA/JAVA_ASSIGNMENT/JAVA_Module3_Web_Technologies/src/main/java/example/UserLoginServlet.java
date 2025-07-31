package example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("admin".equals(username) && "admin".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", username);

			Cookie userCookie = new Cookie("username", username);
			userCookie.setMaxAge(3600);
			response.addCookie(userCookie);

			response.sendRedirect("userWelcome.jsp");
		} else {
			request.setAttribute("error", "Invalid username or password!");
			RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
			rd.forward(request, response);
		}
	}

}
