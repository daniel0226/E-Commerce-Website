package eCommerce.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        response.setContentType("text/html;charset=UTF-8");

        //Replace this with database stuff
        String emailLogin = request.getParameter("email");
        String passwordLogin = request.getParameter("password");
        
        //This returns "on" if checked
        //and null if not checked
        String rememberMeIsChecked = request.getParameter("rmCheckBox");
     
     
        
        //Debug stuff, maybe we'll use loggers and generate log files instead?
        //PrintWriter out = response.getWriter();
        //String dbg_str = emailLogin + " " + passwordLogin + " has tried to login.";
        //debugOutput(out, dbg_str);
        
        if(Validation.validateLoginCredentials(emailLogin,passwordLogin))
        {
        	
        	//Before we redirect, possibly create user data
        	//Create cookie data
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("email", emailLogin);
            
        }else
        {
        	request.getRequestDispatcher("loginError.jsp").include(request, response);  
        }
        
        
    }
    public void debugOutput(PrintWriter out, String output)
    {
    	System.out.println(output);
    	out.println(output);
    }
}