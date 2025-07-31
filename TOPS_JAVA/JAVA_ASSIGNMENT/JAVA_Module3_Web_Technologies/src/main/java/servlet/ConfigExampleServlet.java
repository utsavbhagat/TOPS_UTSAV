package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigExampleServlet
 */
@WebServlet("/ConfigExampleServlet")
public class ConfigExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigExampleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// Get ServletConfig object
		ServletConfig config = getServletConfig();

		// Fetch init parameter
		String company = config.getInitParameter("companyName");

		out.println("<html><body>");
		out.println("<h2>Welcome to " + company + "</h2>");
		out.println("</body></html>");

		String devName = config.getInitParameter("developerName");
		String institute = config.getInitParameter("institute");

		out.println("<html><body>");
		out.println("<h2>Init Parameters via ServletConfig</h2>");
		out.println("<p>Developer: " + devName + "</p>");
		out.println("<p>Institute: " + institute + "</p>");
		out.println("</body></html>");
	}
}
