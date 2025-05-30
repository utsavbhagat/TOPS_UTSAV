package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("login")) {
			String email  = "admin@gmail.com";
			String password = "admin@123";
			String uemail = request.getParameter("email");
			String upass = request.getParameter("password");
			System.out.println(uemail+upass);
			if(uemail.equals(email) && upass.equals(password))  {
				HttpSession session = request.getSession();
//				session.setMaxInactiveInterval(15 * 60);
				session.setAttribute("email",email);
				request.getRequestDispatcher("a-home.jsp").forward(request, response);
			}
			else {
				
			}
		}else if (action.equalsIgnoreCase("doctor")) {
			
		}
	}
	
	

}
