package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import eCommerce.MovieData.Movie;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Database.*;

@WebServlet("/loadObjectsToHtmlController")
public class loadObjectsToHtmlController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private authenticatorController authenticator;
	private sessionController sc;

	public void init() {
		authenticator = new authenticatorController();
		if (Database.getDatabase() == null) {
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public loadObjectsToHtmlController()
	{
		super();
		authenticator = new authenticatorController();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("html;charset=UTF-8");
		sc = new sessionController();
		String requestType = request.getParameter("type");
		switch (requestType) 
		{
			case "inTheatres":
				try 
				{
					List<Movie> moviesInTheatresList = Database.getMoviesFromDatabase(true, false);
					String htmlcode = "";
					if (!moviesInTheatresList.isEmpty()) 
					{
						for (int i = 0; i < moviesInTheatresList.size(); i++) 
						{
							Movie currentMovie = moviesInTheatresList.get(i);
							String movieHTML = generateHTMLController.generateInTheatres(currentMovie);
							htmlcode += movieHTML;
						}
					}
					request.setAttribute("moviesInTheatresList", htmlcode);
					sc.navigatePage(request, response, "/inTheatres.jsp");
					return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			case "comingSoon":
				System.out.println("Coming");
				try {
					List<Movie> moviesInTheatresList = Database.getMoviesFromDatabase(false, true);
					String htmlcode = "";
					if (!moviesInTheatresList.isEmpty()) 
					{
						for (int i = 0; i < moviesInTheatresList.size(); i++) 
						{
							Movie currentMovie = moviesInTheatresList.get(i);
							String movieHTML = generateHTMLController.generateComingSoon(currentMovie);
							htmlcode += movieHTML;
						}
					}
					request.setAttribute("moviesInTheatresList", htmlcode);
					sc.navigatePage(request, response, "/comingSoon.jsp");
					return;
				} catch (SQLException e) {
					e.printStackTrace();
					break;
				}
			case "searchMovies":
				// Need to implement
				sc.navigatePage(request, response, "/SearchView.jsp");
				return;
			case "admin":
				if(sessionData.getCurrentSessionUser() != null)
				{
					setAdminPage(request, response, sessionData.getCurrentSessionUser());
				}
				else {
					sc.navigatePage(request, response, "/login.jsp");
				}
				return;
			default:
				loadMoviePage(request, response, requestType);
				return;
		}
	}
	
	public void loadMoviePage(HttpServletRequest request, HttpServletResponse response, String movieTitle)
	{
		Movie movieToLoad = Database.getMovie(movieTitle);
		sc = new sessionController();
		
		if(movieToLoad == null)
		{
			sc.navigatePage(request, response, "/index.jsp");
			return;
		}
		
		setMoviePage(request,response,movieToLoad);
		sc.navigatePage(request, response, "/movieInfo.jsp" + "?" + movieToLoad.getMovieTitle());
	}
	
	public void setMoviePage(HttpServletRequest request, HttpServletResponse response, Movie movie)
	{
		request.setAttribute("movieTrailer", generateHTMLController.movieInfoTrailer(movie));
		request.setAttribute("movieTitle", movie.getMovieTitle());
		request.setAttribute("Director", movie.getMovieDirector());
		request.setAttribute("Producer", movie.getMovieProducer());
		request.setAttribute("Cast", movie.getMovieCast());
		request.setAttribute("Rating", movie.getMovieRating());
		request.setAttribute("Category", movie.getMovieCategory());
		request.setAttribute("ReleaseDate", movie.getMovieReleaseDate());
		request.setAttribute("Synopsis", movie.getMovieSynopsis());
		request.setAttribute("Reviews", generateHTMLController.movieReviews(movie));
		request.setAttribute("showTimes", generateHTMLController.generateMovieInfoShowTimeBody(movie));
		if(dateController.movieIsInTheatres(movie))
		{
			request.setAttribute("Book", generateHTMLController.bookMovieForm(movie));
		}
		if(sessionData.getCurrentSessionUser() != null)
		{
			//int maxLength = 255 - sessionData.getCurrentSessionUser().getFullName().length();
			request.setAttribute("addReview", generateHTMLController.movieReviewForm(movie));
			//request.setAttribute("writeReview", generateHTMLController.writeReview());
		}else
		{
			request.setAttribute("addReview", "<a href=\"sessionController?type=login\">Sign in to add a review</a>");
		}
		return;
	}
	
	public void setAdminPage(HttpServletRequest request, HttpServletResponse response, WebUser user)
	{
		
		try {
    		request.setAttribute("adminName", user.getFullName());
    		request.setAttribute("location", user.getAddress().getCity() + ", " + user.getAddress().getState());
			
    		//Movies Tab
    		request.setAttribute("moviesInTheatres", Database.getMoviesFromDatabase(true, false).size());
        	request.setAttribute("moviesComingSoon", Database.getMoviesFromDatabase(false, true).size());
        	request.setAttribute("moviesArchived", Database.getMoviesArchivedCount());
    		request.setAttribute("mostPopularMovie", Database.getMostPopularMovie());
    		request.setAttribute("movieStats",Database.getMovieStats());
    		request.setAttribute("addMovies", Database.generateMovieHtml(Database.getAllMovies()));
    		
    		//Showtimes Tab
    		request.setAttribute("showtimes", generateHTMLController.adminShowTimeBody());
    		request.setAttribute("showingsCount", Database.getNumberOfShowingsCount());
    		request.setAttribute("showtimeCount", Database.getMovieShowTimesCount());
			request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
		} catch (ServletException | IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return;
	}
	
	public void setProfilePage(HttpServletRequest request, HttpServletResponse response, WebUser user)
	{
		Address address = user.getAddress();
    	Card card = Database.getCard(user.getEmail());
		sc = new sessionController();
    	
    	request.setAttribute("name", user.getFullName());
    	
    	//User
		request.setAttribute("fName", user.getFirstName());
		request.setAttribute("lName", user.getLastName());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("phonenumber", user.getPhoneNumber());
		request.setAttribute("bDay", user.getBirthday());
		request.setAttribute("checkbox", generateHTMLController.promoCheckBox(user.isReceivingPromoUpdates()));
		
		//Payment
		request.setAttribute("cardname", card.getCardName());
		request.setAttribute("cardEnding", card.getCardEnding());
		request.setAttribute("cardExpDate", card.getExpirationDate());
	
		//Address
		request.setAttribute("addressLine", address.toString());
		
		//Eventually re placed with database.
		List<Movie> bookedMovies = new LinkedList<Movie>();
		Movie movie = Database.getMovie("Joker");
		//List<Movie> bookedMovies = Database.getUserBookedMovies(user);
		bookedMovies.add(movie);
		String bookedMoviesHTML = "";
		for(int i = 0; i<bookedMovies.size(); i++)
		{
			bookedMoviesHTML += generateHTMLController.profileMovieBooking(bookedMovies.get(i));
		}
		request.setAttribute("bookedMovies",bookedMoviesHTML);
    	sc.navigatePage(request, response, "/profilePage.jsp");
	}
	public void setEditPage(HttpServletRequest request, HttpServletResponse response, WebUser user) throws ServletException, IOException
	{
		Address address = user.getAddress();
    	Card card = Database.getCard(user.getEmail());
    	request.setAttribute("name", user.getFullName());
		sc = new sessionController();
    	
    	//User
		request.setAttribute("fName", user.getFirstName());
		request.setAttribute("lName", user.getLastName());
		request.setAttribute("phonenumber", user.getPhoneNumber());
		request.setAttribute("bDay", user.getBirthday());
		request.setAttribute("checkbox", generateHTMLController.promoCheckBox(user.isReceivingPromoUpdates()));
		
		//Payment
		request.setAttribute("cardname", card.getCardName());
		request.setAttribute("CVV", authenticator.decryptString(card.getCVV()));
		request.setAttribute("cardNumber", authenticator.decryptString(card.getCardNumber()));
		request.setAttribute("month", card.getCardMonth());
		request.setAttribute("year", card.getCardYear());
		request.setAttribute("cardZipCode", card.getZipCode());
		
		request.setAttribute("runJs", "<script>loadSelect('" + card.getCardMonth() + "','" + card.getCardYear() + "','" + address.getCountry() +"');</script>");
		//Address
		request.setAttribute("addressLine", address.getAddressLine());
		request.setAttribute("city", address.getCity());
		request.setAttribute("state", address.getState());
		request.setAttribute("country", address.getCountry());
		request.setAttribute("billingZipCode", address.getZipCode());
		sc.navigatePage(request, response, "/editProfile.jsp");
    	return;
	}
	public void createNav(HttpSession session, HttpServletRequest request, HttpServletResponse response)
	{
		if(session != null)
		{
			request.setAttribute("nav", generateHTMLController.nav_LI());
		}else
		{
			request.setAttribute("nav", generateHTMLController.nav_LO());
		}
		return;
	}
}
