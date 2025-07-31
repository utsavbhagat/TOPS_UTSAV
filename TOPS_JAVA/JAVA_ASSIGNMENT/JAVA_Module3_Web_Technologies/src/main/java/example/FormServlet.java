package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			String email=request.getParameter("email");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
	        out.println("<h2>Form Submitted Successfully</h2>");
	        out.println("Name: " + name + "<br/>");
	        out.println("Email: " + email);
	        out.println("</body></html>");;
	}

}
