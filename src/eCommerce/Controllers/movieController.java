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

@WebServlet("/movieController")
public class movieController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private loadObjectsToHtmlController loadHtml = null;
	
	public void init() {
		System.out.println("movieController.java: Movie Controller called.");
		loadHtml = new loadObjectsToHtmlController();
		Database.validateDatabase(Database.getDatabase());
	}

	public movieController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String deleteButton = request.getParameter("deleteMoviesFromCheckBox");
		String addButton = request.getParameter("addBtn");
		String updateButton = request.getParameter("update");
		
		String userMovieReview = request.getParameter("movieReview");
		
		if(userMovieReview != null)
		{
			String movieReviewTitle = request.getParameter("reviewSubmit");
			String usersName = sessionData.getCurrentSessionUser().getFullName();
			Database.addMovieReview(movieReviewTitle, userMovieReview, usersName);
			Database.resetDatabase();
			loadHtml.loadMoviePage(request, response, movieReviewTitle);
		}

		// String releaseDate = request.getParameter("releaseDate");
		// Only prints out if numbers are set
		// System.out.println(releaseDate);

		// If we add or delete movies, we have to update every page that displays
		// movies.
		// For example, index page.

		// We received an add button request.
		if (addButton != null) {
			addMovie(request, response);
		}

		// We received an update movie request.
		if (updateButton != null) {
			updateMovie(request, response);
		}

		// We received a delete button request
		if (deleteButton != null) {
			// If checkboxes is selected, checkbox will print the value set in the HTML
			// For example: <input type="checkbox" value ="joker"> will print joker
			removeMovies(request, response);
		}
	}
	public void updateMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Movie movieToEdit = Database.getMovie(request.getParameter("update"));
	
		String pictureUrl = request.getParameter("pic" + movieToEdit.getMovieTitle());
		if(pictureUrl == null || pictureUrl.equals(""))
		{
			pictureUrl = movieToEdit.getMoviePicture();
		}
		Movie newMovieValues = new Movie(	pictureUrl,
											request.getParameter("video" + movieToEdit.getMovieTitle()),
											request.getParameter("title" + movieToEdit.getMovieTitle()),
											request.getParameter("category" + movieToEdit.getMovieTitle()),
											request.getParameter("director" + movieToEdit.getMovieTitle()),
											request.getParameter("producer" + movieToEdit.getMovieTitle()),
											request.getParameter("synopsis" + movieToEdit.getMovieTitle()),
											request.getParameter("Rated" + movieToEdit.getMovieTitle()),
											request.getParameter("expirationDate" + movieToEdit.getMovieTitle()),
											request.getParameter("releaseDate" + movieToEdit.getMovieTitle()),
											request.getParameter("cast") + movieToEdit.getMovieCast());
		Database.updateMovie(newMovieValues, movieToEdit);
		Database.resetDatabase();
		WebUser user = sessionData.getCurrentSessionUser();
		loadHtml.setAdminPage(request, response, user);
    	return;
	}
	
	public void removeMovies(HttpServletRequest request, HttpServletResponse response)
	{
		String[] Checkboxes = request.getParameterValues("movieCheckbox");
		if (Checkboxes != null && Checkboxes.length != 0) {
			for (int i = 0; i < Checkboxes.length; i++) {
				String currMovie = Checkboxes[i];
				Database.removeMovie(currMovie);
			}
		}
		Database.resetDatabase();
		WebUser user = sessionData.getCurrentSessionUser();
		loadHtml.setAdminPage(request, response, user);
		return;
	}
	public void addMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Movie movie = new Movie(request.getParameter("pic"), 
				request.getParameter("video"),
				request.getParameter("title"), 
				request.getParameter("category"),
				request.getParameter("director"), 
				request.getParameter("producer"),
				request.getParameter("synopsis"), 
				request.getParameter("Rated"),
				request.getParameter("expirationDate"), 
				request.getParameter("releaseDate"),
				request.getParameter("cast"));
			
			try {
				if(Validator.movieAlreadyExists(movie))
				{
					request.setAttribute("addMovieError", ERROR_DATA.MOVIE_ALREADY_EXISTS);
				}else 
				{
					Database.addMovie(movie);
				}
				Database.resetDatabase();
				WebUser user = sessionData.getCurrentSessionUser();
				loadHtml.setAdminPage(request, response, user);
	        	return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
