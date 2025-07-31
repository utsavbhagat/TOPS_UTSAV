package example;
/*Writeafilter that checks whether form input fields are empty. If they are, forward back to
the input form; otherwise, proceed with the request*/
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/SubmitServlet") // Change this path based on the servlet you want to filter
public class InputValidationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("inputForm.jsp");
            dispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response); // Proceed if valid
        }
    }

    public void destroy() {
        // Cleanup if needed
    }
	

}
