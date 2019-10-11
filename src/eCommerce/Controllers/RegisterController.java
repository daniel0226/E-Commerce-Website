package eCommerce.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public RegisterController()
	{
		super();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
        response.setContentType("text/html;charset=UTF-8");

	    //Replace this with database stuff
        //Required Fields
        String firstName 		= request.getParameter("First_Name");
        String lastName 		= request.getParameter("Last_Name");
        String password 		= request.getParameter("password");
        String confirmPassword 	= request.getParameter("confirmPassword");
        String emailAddress 	= request.getParameter("email");
        String birthday 		= request.getParameter("birthday");
        
        //Optional Payment Fields
	}
}
