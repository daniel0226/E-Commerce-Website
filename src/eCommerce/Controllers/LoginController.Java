package eCommerce.Controllers;

import javax.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginController extends HTTPServlet
{
    public void init () throws ServletException
    {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        String emailLogin = response.getParameter("email");
        String passwordLogin = response.getParameter("password");
        validateLogin(emailLogin, passwordLogin);
    }
    public void validateLogin()
    {
        //Create Database Object
        //Connect to Database
        //Validate credentials
        //If error exit
    }
}