package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;

import java.sql.SQLException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.Database;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.sessionData;
import eCommerce.users.Administrator;

@WebServlet("/employeeController")
public class employeeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		Database.validateDatabase(Database.getDatabase());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		response.setContentType("html;charset=UTF-8");
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		if(request.getParameter("addEmployee") != null)
		{
			addEmployee(request, response);
		}
		request.setAttribute("js", generateHTMLController.navigateDiv("empBtn", "Employees"));
		loadHtml.setAdminPage(request, response, sessionData.getCurrentSessionUser());
		
	}
	public void addEmployee(HttpServletRequest request, HttpServletResponse response)
	{
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String Email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneNumber = request.getParameter("phonenumber");
		Administrator admin = new Administrator(firstName, 
												lastName,
												password,
												Email,
												phoneNumber);
		Database.addAdmin(admin);
		Database.addAdminToUsers(admin);
		Database.resetDatabase();
	}
}
