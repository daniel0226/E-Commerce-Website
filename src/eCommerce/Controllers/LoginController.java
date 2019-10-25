package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import eCommerce.Error.*;
import eCommerce.UserData.sessionData;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Validator.Validator;
import eCommerce.users.Users;
import eCommerce.users.WebUser;
import eCommerce.Database.*;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		System.out.println("LoginController.java: Login was called");
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
        	request.setAttribute("loginError", ERROR_DATA.USER_HAS_NOT_VERIFIED_EMAIL);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        if(Validator.userIsSuspended(emailLogin))
        {
        	request.setAttribute("loginError", ERROR_DATA.BANNED);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        
        //If all is good
        
        if(rememberMeIsChecked.equals("on"))
        {
        	//Create cookie
        }
        //Create session
    	//HttpSession session = request.getSession();
    	//session.setAttribute("email", emailLogin);
    	
        WebUser user = Database.getUser(emailLogin);
        
        sessionData createSession = new sessionData(request, user);
        HttpSession session = createSession.createSession();
        System.out.println("Welcome: " + (String)session.getAttribute("email"));
        if(user.getSessionType().equals("admin")) 
        {
        	try {
        		request.setAttribute("adminName", user.getFullName());
				request.setAttribute("moviesInTheatres", Database.getMoviesFromDatabase(true, false).size());
	        	request.setAttribute("moviesComingSoon", Database.getMoviesFromDatabase(false, true).size());
	        	request.setAttribute("moviesArchived", 5);
	    		request.setAttribute("mostPopularMovie", Database.getMostPopularMovie());
	    		request.setAttribute("movieStats",Database.getMovieStats());
	    		request.setAttribute("addMovies", Database.generateMovieHtml(Database.getAllMovies()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
        }else if(user.getSessionType().equals("web"))
        {
        	request.getRequestDispatcher("/profilePage.jsp").forward(request, response);
        	//response.sendRedirect("index.jsp");
        	return;
        }
       
    }

}