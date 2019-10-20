package eCommerce.Controllers;

import eCommerce.Validator.*;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/passwordController")
public class passwordController extends HttpServlet {
	 private static final long serialVersionUID = 2L;

     public passwordController() {
             super();
     }
     
     // If this is called, user is updating new password
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
         
    	 response.setContentType("html;charset=UTF-8");
         String password = request.getParameter("password");
         String confirmPassword = request.getParameter("confirmPassword");
    
     }
     
     //If this is called, user is getting email confirmation for new password
     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
    	 response.setContentType("text/html;charset=UTF-8");
         String emailAddress = request.getParameter("email");
         
     }
}