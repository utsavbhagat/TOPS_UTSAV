package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		((ServletResponse) request).setContentType("text/html");
		PrintWriter out = ((ServletResponse) request).getWriter();

		ServletConfig config = getServletConfig();
		String adminName = config.getInitParameter("adminName");
		String adminEmail = config.getInitParameter("adminEmail");

		out.println("<h2>Initialization Parameters from web.xml</h2>");
		out.println("<p>Admin Name: " + adminName + "</p>");
		out.println("<p>Admin Email: " + adminEmail + "</p>");
	}

	
}
