package HttpRequestHandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpRequestHandler
 */
@WebServlet("/HttpRequestHandler")
public class HttpRequestHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>GET request received</h3>");
		out.println("<form method='post' action='HttpRequestHandler'>");
		out.println("Name: <input type='text' name='username'>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>POST request received</h3>");
		out.println("<p>Hello, " + name + "!</p>");
	}

}
