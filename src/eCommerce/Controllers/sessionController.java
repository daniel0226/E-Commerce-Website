package eCommerce.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import eCommerce.Strings.ERROR_DATA;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;

@WebServlet("/sessionController")
public class sessionController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private loadObjectsToHtmlController loadHtml;
	
	public void init()
	{
		loadHtml = new loadObjectsToHtmlController();
		System.out.println("SessionController Invoked.");
	}
	
	public sessionController()
	{
		super();
		loadHtml = new loadObjectsToHtmlController();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		response.setContentType("html;charset=UTF-8");
		String requestType = request.getParameter("type");
		String requestPage = request.getParameter("page");
		if(requestPage != null)
		{
			navigatePage(request, response, requestPage);
			return;
		}
		session = sessionData.getCurrentSession();
		loadHtml.createNav(session, request, response);
		
		switch(requestType)
		{
			case "edit":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
					navigatePage(request, response, "/login.jsp");
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
					navigatePage(request, response, "/login.jsp");
		            return;
				}else
				{   
					loadHtml.setProfilePage(request, response, sessionData.getCurrentSessionUser());
					return;
		        }
			case "login":
				if(session != null)
				{
					navigatePage(request, response, "/index.jsp");
					return;
				}else {
					navigatePage(request, response, "/login.jsp");
					return;
				}
			case "logout":
				if(session == null)
				{
					request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
					navigatePage(request, response, "/login.jsp");
		            return;
				}else
				{
					navigatePage(request, response, "/logoutController");
					return;
				}
				
			case "register":
				if(session == null)
				{
					navigatePage(request, response, "/register.jsp");
					return;
				}else {
					navigatePage(request, response, "/index.jsp");
					return;
				}
			case "promo":
				if(session == null)
				{
					navigatePage(request, response, "/register.jsp");
				}else
				{
					loadHtml.setEditPage(request, response, sessionData.getCurrentSessionUser());
				}
				return;
			case "promotion":
				loadHtml.setPromotionsPage(request, response);
				return;
			default:
				System.out.println("How did this happen???????");
				break;
		}	
	}
	public void navigatePage(HttpServletRequest request, HttpServletResponse response, String page)
	{
		HttpSession session = sessionData.getCurrentSession();
		loadHtml.createNav(session, request, response);
		try {
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
