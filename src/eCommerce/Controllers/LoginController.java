package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import eCommerce.Strings.ERROR_DATA;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;
import eCommerce.Database.*;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private loadObjectsToHtmlController loadHtml = null;
	private sessionController sessionControl = null;
	
	public void init()
	{
		sessionControl = new sessionController();
		loadHtml = new loadObjectsToHtmlController();
		System.out.println("LoginController.java: Login was called");
		Database.validateDatabase(Database.getDatabase());
	}
	
	public LoginController()
	{
		super();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
        response.setContentType("html;charset=UTF-8");

        String emailLogin = request.getParameter("email");
        String passwordLogin = request.getParameter("password");
           
        //This returns "on" if checked
        //and null if not checked
        String rememberMeIsChecked = request.getParameter("rmCheckBox");
        if(rememberMeIsChecked != null)
        {
        	
        }
     
        //Login Checks
        //Password and password confirmation is checked in HTML
        //Session is checked in sessionController
        
        if(!Validator.validateLoginCredentials(emailLogin,passwordLogin))
        {
            request.setAttribute("loginError", ERROR_DATA.INVALID_LOGIN_ERROR);
            sessionControl.navigatePage(request, response, "/login.jsp");
            return;
        }
        
        if(!Validator.userHasConfirmedLogin(emailLogin))
        {
        	request.setAttribute("loginError", ERROR_DATA.USER_HAS_NOT_VERIFIED_EMAIL);
        	sessionControl.navigatePage(request, response, "/login.jsp");
            return;
        }
        
        if(Validator.userIsSuspended(emailLogin))
        {
        	request.setAttribute("loginError", ERROR_DATA.BANNED);
        	sessionControl.navigatePage(request, response, "/login.jsp");
            return;
        }
        
        
        //If all is good
        //Create session
    	//HttpSession session = request.getSession();
    	//session.setAttribute("email", emailLogin);

        WebUser user = Database.getUser(emailLogin);
        sessionControl.createUserSession(request, user);
        
        if(user.getSessionType().equals("admin")) 
        {
        	loadHtml.setAdminPage(request, response ,user);
        }
        else if(user.getSessionType().equals("web"))
        {
        	sessionControl.navigatePage(request, response, "/index.jsp");
        }
        return;
    }
}