package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/bookingController")
public class bookingController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Booking Controller has been instantiated.");
		if(Database.getDatabase() == null)
		{
			try {
				Database db = new Database();
				System.out.println(db.databaseConnected());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public bookingController()
	{
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String movieToBook = request.getParameter("book");
		String requestType = request.getParameter("type");
		//Returns movie title
		
		if(!Validator.validateUserIsLoggedIn())
		{
			request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
		}
		
		if(requestType != null && !requestType.equals(""))
		{
			System.out.println(requestType);
		}
		
		if(movieToBook != null && !movieToBook.equals(""))
		{
			System.out.println(movieToBook);
		}
		
		return;
	}
}
