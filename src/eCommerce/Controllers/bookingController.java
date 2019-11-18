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
import eCommerce.MovieData.ShowTimes;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/bookingController")
public class bookingController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private sessionController sessionC;

	public void init() {
		sessionC = new sessionController();
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
		String requestID = request.getParameter("type");
		//Returns movie title
		
		if(!Validator.validateUserIsLoggedIn())
		{
			//request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
			//sessionC.navigatePage(request, response, "/login.jsp");
            //return;
		}
		
		if(requestID != null && !requestID.equals(""))
		{
			queryTypes(request, response, requestID);
			return;
		}
		
		if(movieToBook != null && !movieToBook.equals(""))
		{
			bookingQuery(request, response, movieToBook);
			return;
		}
		
		return;
	}
	public void bookingQuery(HttpServletRequest request, HttpServletResponse response, String movieTitle)
	{
		sessionController sc = new sessionController();
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		Movie movie = Database.getMovie(movieTitle);
		loadHtml.setSelectShowTimesPage(request, response, movie);
		sc.navigatePage(request, response, "selectView.jsp");
	}
	public void queryTypes(HttpServletRequest request, HttpServletResponse response, String id)
	{
		ShowTimes st = Database.getShowTimeByID(id);
		System.out.println(st.getDate());
	}
}
