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
import eCommerce.Strings.ERROR_DATA;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;

@WebServlet("/profileController")
public class profileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//This class only gets called if
	//sessionController validates that the user is logged in.
	public profileController()
	{
		super();
	}
	
	public void init()
	{
		System.out.println("Updating Profile.");
		if(Database.getDatabase() == null)
		{
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
        response.setContentType("html;charset=UTF-8");
        WebUser user = sessionData.getCurrentSessionUser();
        Address address = user.getAddress();
        Card card = Database.getCard(user.getEmail());
        
        String updateProfile = request.getParameter("submitChange");
        String changePassword = request.getParameter("changePassword");
        
        //We are updating profile.
        if(updateProfile != null && updateProfile.equals("Changes"))
        {
        	System.out.println("Update profile");
        	return;
        }
        
        if(changePassword != null && changePassword.contentEquals("Password"))
        {
        	request.getRequestDispatcher("./passwordPrompt.jsp").forward(request, response);
        	return;
        }
        
        
    }
	

}
