package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleDemoServlet
 */
@SuppressWarnings("serial")
@WebServlet("/LifeCycleDemoServlet")
public class LifeCycleDemoServlet extends HttpServlet {
	// Constructor
	public LifeCycleDemoServlet() {
		System.out.println("Constructor: Servlet instance created.");
	}

	// Called once when servlet is initialized
	public void init() throws ServletException {
		System.out.println("init(): Servlet initialized.");
	}

	// Called for every request (GET/POST)
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service(): Request received.");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>Servlet Life Cycle Demonstration</h3>");
		out.println("<p>Check console/log for method call messages.</p>");
	}

	// Called when servlet is taken out of service
	public void destroy() {
		System.out.println("destroy(): Servlet destroyed.");
	}

}
