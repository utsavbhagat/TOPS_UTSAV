package example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String email=request.getParameter("email");
		
		request.setAttribute("username", name);
		request.setAttribute("useremail", email);

	     // Forward to JSP page to display output
	     RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
	     dispatcher.forward(request, response);
	     }

}
