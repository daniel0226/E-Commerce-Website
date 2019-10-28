package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import eCommerce.MovieData.Movie;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.Strings.email;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;
import eCommerce.Database.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/passwordController")
public class passwordController extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	public passwordController()
	{
		super();
	}
	
	public void init()
	{
		if(Database.getDatabase() == null)
		{
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
		String emailAddress = request.getParameter("email");
		WebUser user = Database.getUser(emailAddress);
		
		//If email doesn't exist in Database
		if(user == null)
		{
			request.setAttribute("errorMsg", ERROR_DATA.INVALID_EMAIL);
			request.getRequestDispatcher("./forgetPassword.jsp").forward(request, response);
			return;
		}else {
			authenticatorController control = new authenticatorController();
			EmailController _email = new EmailController();
			String forgetEmailPass = email.forgetPassMsg + control.decryptString(user.getPassword());
			_email.sendEmail(user, email.forgotPassword, forgetEmailPass);
			request.setAttribute("loginError", email.forgotPasswordSent);
			request.getRequestDispatcher("./login.jsp").forward(request, response);
			return;
			
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("html;charset=UTF-8");
		//Button Types
		String enterPassword = request.getParameter("enterPassword");
		String updatePassword = request.getParameter("infS");
		
		//User Info
		authenticatorController control = new authenticatorController();
		WebUser user = sessionData.getCurrentSessionUser();
		String userPassword = control.decryptString(user.getPassword());
		
		//Enter password before changing password
		if(enterPassword != null && enterPassword.equals("Submit"))
		{
			String passwordInput = request.getParameter("password");
			if(userPassword.equals(passwordInput))
			{
				request.getRequestDispatcher("./changePassword.jsp").forward(request, response);
				return;
			}else {
				request.setAttribute("errorMsg", ERROR_DATA.INVALID_PASSWORD);
				request.getRequestDispatcher("./passwordPrompt.jsp").forward(request, response);
				return;
			}
		}
		
		//Change password Page
		if(updatePassword != null && updatePassword.equals("Update Password"))
		{
			//HTML handles if password & confirm Password are equal.
			String newPassword = request.getParameter("password");
			if(newPassword.equals(userPassword))
			{
				request.setAttribute("errorMsg", ERROR_DATA.NOT_UNIQUE_PASSWORD);
				request.getRequestDispatcher("./changePassword.jsp").forward(request, response);
				return;
			}else
			{
				Database.updatePassword(user, newPassword);
				if(sessionData.logout())
				{
					System.out.println("Please login with new password.");
				}
				Database.resetDatabase();
				request.setAttribute("loginError", generateHTMLController.passwordSuccessfullyUpdated());
				request.getRequestDispatcher("./login.jsp").forward(request, response);
				return;
			}
		}
		
	}
}
