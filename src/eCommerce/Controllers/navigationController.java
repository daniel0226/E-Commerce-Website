package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Error.ERROR_DATA;
import eCommerce.MovieData.Movie;
import eCommerce.debug.Debug;
import eCommerce.Database.Database;
import eCommerce.Controllers.generateHTMLController;
@WebServlet("/navigationController")
public class navigationController extends HttpServlet {

	private Database db = null;
	private String movieHTML = "";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init()
	{
		if(db == null)
		{
			try {
				db = new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Database connection established.");
		}else
		{
			System.out.println("Database: " + Database.getDatabase());
		}
	}
	public navigationController()
	{
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException 
	{	
		String navigateToString = request.getParameter("navigateToString");
		System.out.println("Redirecting to: " + navigateToString);
		
		if(navigateToString.equals("inTheatres.jsp"))
		{
			request.getRequestDispatcher(navigateToString).forward(request, response);
		}
	}
	
	public static void navigateLink(String link)
	{
		
	}
}
