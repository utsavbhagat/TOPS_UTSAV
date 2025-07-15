package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.SessionUserDao;
import model.SessionUser;
import service_OTP.Servicesss;


@WebServlet("/SessionUserController")
public class SessionUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			SessionUser SesU = new SessionUser();
			SesU.setFirstname(request.getParameter("firstName"));
			SesU.setLastname(request.getParameter("lastName"));
			SesU.setEmail(request.getParameter("email"));
			SesU.setContact(Long.parseLong(request.getParameter("mobile")));
			SesU.setAddress(request.getParameter("address"));
			SesU.setGender(request.getParameter("gender"));
			SesU.setPassword(request.getParameter("password"));
			SesU.setconfirmpassword(request.getParameter("confirmPassword"));
			if (!SesU.getPassword().equals(SesU.getconfirmpassword())) {
		        request.setAttribute("msg", "Password and Confirm Password do not match!");
		        request.getRequestDispatcher("signup.jsp").forward(request, response);
		        return;
		    }
			System.out.println(SesU);
			boolean flag = SessionUserDao.checkSessionUserEmail(request.getParameter("email"));
			if(flag == false) {
				SessionUserDao.insertUser(SesU);
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("msg","Account already registered!");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("login")) {
			SessionUser SesU = new SessionUser();
			SesU.setEmail(request.getParameter("email"));
			SesU.setPassword(request.getParameter("password"));
			System.out.println(SesU);
			boolean flag = SessionUserDao.checkSessionUserEmail(request.getParameter("email"));
			System.out.println(flag);
			if (flag=true) {
				SessionUser SesU1 = SessionUserDao.SessionUserLogin(SesU);
				System.out.println("SesU1 : "+SesU);
				if(SesU1!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("data",SesU1);
					request.getRequestDispatcher("main_dashboard.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Password is Incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Account not found");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			}
		
		else if(action.equalsIgnoreCase("fp")) {
			String email = request.getParameter("email");
			boolean flag= SessionUserDao.checkSessionUserEmail(email);
			if(flag == true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				System.out.println(num);
				Servicesss s = new Servicesss();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("verify_otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "account doen't exist !");
				request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("new_password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("otp", otp1);
				request.setAttribute("email", email);
				request.setAttribute("msg", "OTP not matched");
				request.getRequestDispatcher("verify_otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("np")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if(np.equals(cnp)) {
				SessionUserDao.newPassword(email, np);
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("msg", "password not matched");
				request.getRequestDispatcher("new_password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("cp")) {
			int id = Integer.parseInt(request.getParameter("suid"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = SessionUserDao.checkOldPassword(id, op);
			if(flag == true) {
				if(np.equals(cnp)) {
					SessionUserDao.changePassword(id, np);
					response.sendRedirect("main_dashboard.jsp");
				}
				else {
					request.setAttribute("msg", "Password not matched");
					request.getRequestDispatcher("change_password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Old Password incorrect");
				request.getRequestDispatcher("change_password.jsp").forward(request, response);
			}
		}
		
		
		}
	}


