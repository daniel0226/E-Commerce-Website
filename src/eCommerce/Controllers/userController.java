package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;

@WebServlet("/userController")
public class userController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		Database.validateDatabase(Database.getDatabase());
	}
	public userController()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{ 
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		sessionController sc = new sessionController();
		String userSearch = request.getParameter("searchName");
		String suspend = request.getParameter("Suspend");
		String unSuspend = request.getParameter("UnSuspend");
		String delete = request.getParameter("Delete");
		WebUser user = Database.getUser(request.getParameter("Email"));
		
		if(userSearch != null)
		{
			loadHtml.setAdminUserSearchPage(request, response, userSearch);
		}else if(suspend != null)
		{
			Database.suspendUser(user);
		}else if(unSuspend != null)
		{
			Database.unSuspendUser(user);
		}else if(delete != null)
		{
			Database.deleteUser(user);
		}
		
		Database.resetDatabase();
		request.setAttribute("js", generateHTMLController.navigateDiv("userBtn", "Users"));
		loadHtml.setAdminPage(request, response, sessionData.getCurrentSessionUser());
		//sc.navigatePage(request, response, "adminPage.jsp");
		
	}
}