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

@WebServlet("/orderSummaryController")
public class orderSummaryController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public orderSummaryController()
	{
		super();
	}
	
	public void init() {
		System.out.println("Order Summary Controller has been instantiated.");
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
	
	public void getMovieTitle(String movie) {
		movie = Database.getMovie(movie);
	}
	
	
}
