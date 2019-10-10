package eCommerce.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginController extends HTTPServlet
{
    public void init () throws ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        response.setContentType("text/html;charset=UTF-8");

        String emailLogin = response.getParameter("email");
        String passwordLogin = response.getParameter("password");
        PrintWriter out = response.getWrite();
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