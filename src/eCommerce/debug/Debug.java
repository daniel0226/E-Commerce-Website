package eCommerce.debug;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eCommerce.MovieData.*;

/*
 * 
 * EVENTUALLY GOING TO MAKE A COPY OF THIS
 * THE COPY WILL BE A CONTROLLER FOR ADMIN LOGIN
 * 
 * */

public class Debug {
	
	private static String debugEmail = "test@gmail.com";
	private static String debugPassword ="12345";
	private static String adminName = "Daniel Yong Kim";
	
	//Analytics
	private static int moviesBooked = 241;
	private static String mostPopularMovie = "<img src=\"images/MoviePhoto/JokerWallpaper.jpg\" alt=\"joker\">";
	private static int moviesInTheatres = 12;
	private static int moviesComingSoon = 21;
	private static int moviesArchived = 205;
	
	public Debug()
	{
		
	}
	
	public static void debugAdminPageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("adminName", getAdminName());
    	request.setAttribute("moviesInTheatres", getMoviesInTheatres());
    	request.setAttribute("moviesComingSoon", getMoviesComingSoon());
    	request.setAttribute("moviesArchived", getMoviesArchived());
		request.setAttribute("mostPopularMovie", getMostPopularMovie());
		request.setAttribute("movieStats",getMovieStats());
    	request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
	}
	
	public static void debugAddMovie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Part filePart = request.getPart("name");
		Movie movie = new Movie(request.getParameter("pic"), 
								request.getParameter("video"), 
								request.getParameter("title"), 
								request.getParameter("category"), 
								request.getParameter("director"), 
								request.getParameter("producer"),
								request.getParameter("synopsis"), 
								request.getParameter("Rated"), 
								request.getParameter("expirationDate"), 
								request.getParameter("releaseDate"));
		System.out.println(movie.getMoviePicture());
		System.out.println(movie.getMovieTrailer());
		System.out.println(movie.getMovieTitle());
		System.out.println(movie.getMovieCategory());
		System.out.println(movie.getMovieDirectory());
		System.out.println(movie.getMovieProducer());
		System.out.println(movie.getMovieSynopsis());
		System.out.println(movie.getMovieRating());
		System.out.println(movie.getMovieExpDate());
		System.out.println(movie.getMovieReleaseDate());
	}
	
	public static String getMovieStats()
	{
		String movieStats = "<p>Joker#33</p>" + 
			"<p>Lion King#14</p>" +
			"<p>Gemini Man#12</p>" +
			"<p>Maleficent#21</p>" +
			"<p>The Addams Family#18</p>";
		return movieStats;
	}

	public static String getMostPopularMovie()
	{
		return mostPopularMovie;
	}
	
	public static int getMoviesBookedCount()
	{
		return moviesBooked;
	}
	
	public static String getEmail()
	{
		return debugEmail;

	}
	
	public static String getPassword()
	{
		return debugPassword;
	}
	
	public static int getMoviesInTheatres()
	{
		return moviesInTheatres;
	}
	
	public static int getMoviesComingSoon()
	{
		return moviesComingSoon;
	}
	
	public static int getMoviesArchived()
	{
		return moviesArchived;
	}
	
	public static String getAdminName()
	{
		return adminName;
	}
}
