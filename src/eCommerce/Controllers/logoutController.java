package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Database.Database;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.sessionData;

@WebServlet("/logoutController")
public class logoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private sessionController sessionControl;
	
	public void init()
	{
		Database.validateDatabase(Database.getDatabase());
		sessionControl = new sessionController();
		System.out.println("logoutController.java: Logout user called.");
	}
	public logoutController()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
		HttpSession session = sessionData.getCurrentSession();
		sessionControl.logoutUser(session, request);
		String printLogout = generateHTMLController.logoutSuccessful();
		sessionData.resetData();
		request.setAttribute("loginError", printLogout);
		sessionControl.navigatePage(request, response, "/login.jsp");
		return;
    }

}