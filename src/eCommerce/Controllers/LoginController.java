package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import eCommerce.Error.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.*;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public LoginController()
	{
		super();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
        response.setContentType("html;charset=UTF-8");

        //Replace this with database stuff
        String emailLogin = request.getParameter("email");
        String passwordLogin = request.getParameter("password");
           
        //This returns "on" if checked
        //and null if not checked
        String rememberMeIsChecked = request.getParameter("rmCheckBox");
     
     
        //If user is already logged in, don't try logging in again.
        //if(!Validator.validateSession(emailLogin));
        //{
        //	Check session maybe? Need to look into this.
        //}
        
        if(!Validator.validateLoginCredentials(emailLogin,passwordLogin))
        {
            request.setAttribute("loginError", ERROR_DATA.INVALID_LOGIN_ERROR);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        if(!Validator.userHasConfirmedLogin(emailLogin))
        {
        	
        }
        
        if(!Validator.userIsSuspended(emailLogin))
        {
        	
        }
        
        
        //If all is good
        
        if(rememberMeIsChecked.equals("on"))
        {
        	//Create cookie
        }
        //Create session
    	//HttpSession session = request.getSession();
    	//session.setAttribute("email", emailLogin);
    	
    	//If admin login
    	//if(user is admin)
    	/*
    	 * 
    	 *
          request.setAttribute("adminName", admin name from db);
          request.setAttribute(all of the analytics)
          request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
    	 */
        //Debug admin stuff
       
    }

}