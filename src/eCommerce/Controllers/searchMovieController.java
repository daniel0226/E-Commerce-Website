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

@WebServlet("/searchMovieController")
public class searchMovieController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private sessionController sc;
	
	public void init()
	{
		sc = new sessionController();
		System.out.println("searchMovieController.java has been instantiated.");
		Database.validateDatabase(Database.getDatabase());
	}
	public searchMovieController()
	{
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userSearch = request.getParameter("input");
		String searchOption = request.getParameter("searchOption");
		String adminShowTimeSearch = request.getParameter("showtimesearch");
		System.out.println(userSearch + " " + searchOption);
		
		if(adminShowTimeSearch != null && !adminShowTimeSearch.equals(""))
		{
			displayShowTimeResults(request, response, adminShowTimeSearch);
			return;
		}
		
		
		if(searchOption == null || searchOption.equals(""))
		{
			searchOption = "title";
		}
		
		if(searchOption.equals("category"))
		{
			try {
				searchByCategory(request, response, userSearch);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(searchOption.equals("title"))
		{
			try {
				searchByTitle(request, response, userSearch);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}else if(searchOption.equals("comingSoon"))
		{
			try {
				searchComingSoon(request, response, userSearch);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(searchOption.equals("inTheatres"))
		{
			try {
				searchInTheatres(request, response, userSearch);
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		sc.navigatePage(request, response, "/SearchView.jsp");
		return;
	}

	public void displayShowTimeResults(HttpServletRequest request, HttpServletResponse response, String userInput)
	{
		loadObjectsToHtmlController load = new loadObjectsToHtmlController();
		request.setAttribute("Results", generateHTMLController.adminShowTimeResults(userInput));
		request.setAttribute("js", generateHTMLController.navigateDiv("showtimeBtn","Showtimes"));
		load.setAdminPage(request, response, sessionData.getCurrentSessionUser());
		return;
	}
	
	public void searchByCategory(HttpServletRequest request, HttpServletResponse response, String query) throws SQLException
	{
		List<Movie> moviesList = Database.getMoviesByCategory(query);
		if(moviesList.size() == 0)
		{
			NO_MOVIES_FOUND(request, response);
		}else
		{
			String html = "";
			for(int i = 0; i<moviesList.size(); i++)
			{
				html += generateHTMLController.generateInTheatres(moviesList.get(i));
			}
			if(html.equals(""))
			{
				NO_MOVIES_FOUND(request, response);
			}else {
				request.setAttribute("movieResults", html);
			}
		}
	}
	
	public void searchByTitle(HttpServletRequest request, HttpServletResponse response, String query) throws SQLException
	{
		List<Movie> moviesList = Database.getMoviesbyTitle(query);
		String html = "";
		
		if(moviesList.size() == 0)
		{
			NO_MOVIES_FOUND(request, response);
		}
		else
		{
			for(int i = 0; i<moviesList.size(); i++)
			{
				html += generateHTMLController.generateInTheatres(moviesList.get(i));
			}
			
			if(html.equals(""))
			{
				NO_MOVIES_FOUND(request, response);
			}else {
				request.setAttribute("movieResults", html);
			}
		}
	}
	public void searchComingSoon(HttpServletRequest request, HttpServletResponse response, String query) throws SQLException
	{
		List<Movie> moviesList = Database.getMoviesbyTitle(query);
		if(moviesList.size() == 0)
		{
			NO_MOVIES_FOUND(request, response);
		}else
		{
			String html = "";
			for(int i = 0; i<moviesList.size(); i++)
			{
				if(dateController.movieIsComingSoon(moviesList.get(i)))
				{
					html += generateHTMLController.generateInTheatres(moviesList.get(i));
				}
			}
			if(html.equals(""))
			{
				NO_MOVIES_FOUND(request, response);
			}else {
				request.setAttribute("movieResults", html);
			}
		}
	}
	public void searchInTheatres(HttpServletRequest request, HttpServletResponse response, String query) throws SQLException
	{
		List<Movie> moviesList = Database.getMoviesbyTitle(query);
		if(moviesList.size() == 0)
		{
			NO_MOVIES_FOUND(request, response);
		}else
		{
			String html = "";
			for(int i = 0; i<moviesList.size(); i++)
			{
				if(dateController.movieIsInTheatres(moviesList.get(i))) 
				{
					html += generateHTMLController.generateInTheatres(moviesList.get(i));
				}
			}
			if(html.equals(""))
			{
				NO_MOVIES_FOUND(request, response);
			}else {
				request.setAttribute("movieResults", html);
			}
		}
	}
	
	public void NO_MOVIES_FOUND(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("errorMsg", ERROR_DATA.MOVIE_DOES_NOT_EXIST);
		return;
	}
}
