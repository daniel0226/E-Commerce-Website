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

@WebServlet("/searchMovieController")
public class searchMovieController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private sessionController sc;
	
	public void init()
	{
		sc = new sessionController();
		System.out.println("searchMovieController.java has been instantiated.");
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
	public searchMovieController()
	{
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userSearch = request.getParameter("search");
		String searchOption = request.getParameter("searchOption");
		
		if(searchOption.equals("By Category"))
		{
			try {
				searchByCategory(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(searchOption.equals("By Title"))
		{
			try {
				searchByTitle(request, response);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		sc.navigatePage(request, response, "/SearchView.jsp");
		return;
	}

	public void searchByCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException
	{
		List<Movie> moviesList = Database.getAllMovies();
	}
	
	public void searchByTitle(HttpServletRequest request, HttpServletResponse response) throws SQLException
	{
		List<Movie> moviesList = Database.getAllMovies();
	}
}
