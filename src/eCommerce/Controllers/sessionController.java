package eCommerce.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Database.Database;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;

@WebServlet("/sessionController")
public class sessionController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private authenticatorController authenticator;
	private loadObjectsToHtmlController loadHtml;
	
	public void init()
	{
		authenticator = new authenticatorController();
		loadHtml = new loadObjectsToHtmlController();
		System.out.println("SessionController Invoked.");
	}
	
	public sessionController()
	{
		super();
		authenticator = new authenticatorController();
		loadHtml = new loadObjectsToHtmlController();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		response.setContentType("html;charset=UTF-8");
		String requestType = request.getParameter("type");
		session = sessionData.getCurrentSession();
		switch(requestType)
		{
			case "edit":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
		            request.getRequestDispatcher("/login.jsp").forward(request, response);
		            return;
				}else
				{   
					loadHtml.setEditPage(request,  response, sessionData.getCurrentSessionUser());
		        	return;
		        }
			case "profile":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
		            request.getRequestDispatcher("/login.jsp").forward(request, response);
		            return;
				}else
				{   
					loadHtml.setProfilePage(request, response, sessionData.getCurrentSessionUser());
					return;
		        }
			case "login":
				if(session != null)
				{
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					return;
				}else {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					return;
				}
			case "logout":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
		            request.getRequestDispatcher("/login.jsp").forward(request, response);
		            return;
				}else
				{
					request.getRequestDispatcher("/logoutController").forward(request, response);
					return;
				}
				
			case "register":
				if(session == null)
				{
					request.getRequestDispatcher("/register.jsp").forward(request, response);
					return;
				}else {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			default:
				System.out.println("How did this happen???????");
				break;
		}	
	}
	public void logoutUser(HttpSession session, HttpServletRequest request)
	{
		if(sessionData.logout())
		{
			System.out.println("Successfully logged out.");
		}else {
			if(session != null)
			{
				session.invalidate();
			}
		}
	}
	public void createUserSession(HttpServletRequest request, WebUser user)
	{
		new sessionData(request, user);
        HttpSession session = sessionData.createSession();
        System.out.println("Welcome: " + (String)session.getAttribute("email"));
        return;
	}
}
