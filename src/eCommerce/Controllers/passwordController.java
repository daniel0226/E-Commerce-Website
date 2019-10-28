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
	
}
