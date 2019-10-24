package eCommerce.Controllers;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Error.ERROR_DATA;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;

@WebServlet("/sessionController")
public class sessionController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HttpSession session;
	
	public void init()
	{
		System.out.println("SessionController Invoked.");
	}
	
	public sessionController()
	{
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		response.setContentType("html;charset=UTF-8");
		String requestType = request.getParameter("type");
		session = sessionData.getCurrentSession();
		switch(requestType)
		{
			case "edit":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
		            request.getRequestDispatcher("/login.jsp").forward(request, response);
		            return;
				}else
				{   
					WebUser user = sessionData.getCurrentSessionUser();
					request.setAttribute("fName", user.getFirstName());
					request.setAttribute("lName", user.getLastName());
					request.setAttribute("email", user.getEmail());
					request.setAttribute("password", "password");
		        	request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
		        	return;
		        }
			case "login":
				if(session != null)
				{
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					return;
				}else {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			case "logout":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
		            request.getRequestDispatcher("/login.jsp").forward(request, response);
		            return;
				}else
				{
					request.getRequestDispatcher("/logoutController").forward(request, response);
					return;
				}
				
			case "register":
				if(session == null)
				{
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return;
				}else {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			default:
				System.out.println("How did this happen???????");
				break;
		}	
	}
}
