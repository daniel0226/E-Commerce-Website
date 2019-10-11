package eCommerce.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public LoginController()
	{
		super();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        String emailLogin = request.getParameter("email");
        String passwordLogin = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.println("Credentials: " + emailLogin + " " + passwordLogin);

        if(Validation.validateLoginCredentials(emailLogin,passwordLogin))
        {
            out.println("Success");   
        }else
        {
           out.println("Failure");
        }
        
    }
}