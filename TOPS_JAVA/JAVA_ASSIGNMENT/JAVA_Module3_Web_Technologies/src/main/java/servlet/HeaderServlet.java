package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set custom response header
		response.setHeader("X-Custom-Header", "example.jsp");

		// Set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Request Headers</title></head><body>");
		out.println("<h2>HTTP Request Headers</h2>");
		out.println("<table border='1'>");
		out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

		// Display request headers
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			String value = request.getHeader(header);
			out.println("<tr><td>" + header + "</td><td>" + value + "</td></tr>");
		}

		out.println("</table>");

		// Show custom response header note
		out.println("<p><strong>Custom Response Header:</strong> X-Custom-Header = HeaderDemo</p>");

		out.println("</body></html>");
	}
}
