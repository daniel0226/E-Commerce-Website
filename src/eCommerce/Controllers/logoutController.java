package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.sessionData;

@WebServlet("/logoutController")
public class logoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		System.out.println("logoutController.java: Logout user called.");
	}
	public logoutController()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
		if(sessionData.logout())
		{
			System.out.println("Successfully logged out.");
		}else {
			HttpSession session = sessionData.getCurrentSession();
			if(session != null)
			{
				session.invalidate();
			}
		}
		String printLogout = generateHTMLController.logoutSuccessful();
		sessionData.resetData();
		request.setAttribute("loginError", printLogout);
		response.sendRedirect("./login.jsp");
		return;
    }

}