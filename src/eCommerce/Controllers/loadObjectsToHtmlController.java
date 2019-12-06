package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import eCommerce.MovieData.Movie;
import eCommerce.MovieData.Seatings;
import eCommerce.MovieData.ShowTimes;
import eCommerce.MovieData.Ticket;
import eCommerce.MovieData.TicketCount;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.Order;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;
import eCommerce.analytics.*;

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
	private Analytics analytics;
	Ticket ticket = new Ticket(7.50, 11.50, 9.50);

	public void init() {
		analytics = new Analytics();
		authenticator = new authenticatorController();
		Database.validateDatabase(Database.getDatabase());
	}
	public loadObjectsToHtmlController()
	{
		super();
		authenticator = new authenticatorController();
		analytics = new Analytics();
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
    		
    		//Promotions Tab
    		request.setAttribute("promoCount", analytics.getNumberOfPromotionAvailable());
    		request.setAttribute("promoUsage", analytics.getNumberOfPromotionTransactions());
    		request.setAttribute("promosArchived", analytics.getPromosArchivedCount());
    		request.setAttribute("promoUpdate", generateHTMLController.adminPromoBody());
    		
    		//Users tba
    		request.setAttribute("employees", generateHTMLController.employeeBody());
    		request.setAttribute("userCount", Database.getAllUsers().size());
    		
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
		if(address == null)
		{
			address = new Address("");
		}
		
    	Card card = Database.getCard(user.getEmail());
    	if(card == null)
		{
			card = new Card();
		}
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
		
		//Order History
		request.setAttribute("orderHistory", generateHTMLController.orderHistory(user));
		
		
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
	public void setPromotionsPage(HttpServletRequest request, HttpServletResponse response)
	{
		sc = new sessionController();
		request.setAttribute("promos", generateHTMLController.promotionsBody());
		sc.navigatePage(request, response, "/currentPromotions.jsp");
    	return;
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
	public void setDateSelect(HttpServletRequest request, HttpServletResponse response, Movie movie)
	{
		request.setAttribute("moviePhoto", movie.getMoviePicture());
		request.setAttribute("title", movie.getMovieTitle());
		request.setAttribute("rating", movie.getMovieRating());
		request.setAttribute("synopsis", movie.getMovieSynopsis());
		request.setAttribute("url", "loadObjectsToHtmlController?type=" + movie.getMovieTitle());
		request.setAttribute("Dates", generateHTMLController.loadDates(movie));
		return;
	}
	public void setSelectShowTimesPage(HttpServletRequest request, HttpServletResponse response, Movie movie, String Date)
	{
		request.setAttribute("moviePhoto", movie.getMoviePicture());
		request.setAttribute("title", movie.getMovieTitle());
		request.setAttribute("rating", movie.getMovieRating());
		request.setAttribute("synopsis", movie.getMovieSynopsis());
		request.setAttribute("url", "loadObjectsToHtmlController?type=" + movie.getMovieTitle());
		request.setAttribute("Theatre1", generateHTMLController.Theatre(movie, 1, Date));
		request.setAttribute("Theatre2", generateHTMLController.Theatre(movie, 2, Date));
		request.setAttribute("Theatre3", generateHTMLController.Theatre(movie, 3, Date));
		return;
	}
	public void setTicketPage(HttpServletRequest request, HttpServletResponse response, Movie movie, ShowTimes showtime)
	{
		request.setAttribute("moviePhoto", movie.getMoviePicture());
		request.setAttribute("cinemaID", "Theatre " + showtime.getCinemaID());
		request.setAttribute("Date", dateController.convertToLocalDate(showtime.getDate()));
		request.setAttribute("Time", dateController.convertToTwelve(showtime.getShowTimes()));
		request.setAttribute("title", movie.getMovieTitle());
		request.setAttribute("id", showtime.getID());
		//Ticket ticket = new Ticket(7.50, 11.50, 9.50);
		request.setAttribute("senior", ticket.seniorToString());
		request.setAttribute("adult", ticket.adultToString());
		request.setAttribute("child", ticket.childToString());
		return;
	}
	public void setSeatingPage(HttpServletRequest request, HttpServletResponse response, TicketCount tc, Seatings seats)
	{
		//ShowTimes st = Database.getShowTimeByID(Integer.toString(seats.getShowTimeId()));
		//WebUser user = sessionData.getCurrentSessionUser();
		//Movie movie = Database.getMovie(st.getMovieTitle());
		request.setAttribute("id", seats.getShowTimeId());
		request.setAttribute("max", tc.totalCount());
		request.setAttribute("adult", tc.getAdultCount());
		request.setAttribute("child", tc.getChildCount());
		request.setAttribute("senior", tc.getSeniorCount());
		request.setAttribute("seatStructure", generateHTMLController.seatStructure(seats));
	}
	public void setOrderSummary(HttpServletRequest request, HttpServletResponse response, TicketCount tc, ShowTimes showtime, List<Boolean> seats, Seatings seat)
	{
		request.setAttribute("title", showtime.getMovieTitle());
		request.setAttribute("Theatre", showtime.getCinemaID());
		String showTimeStr = dateController.convertToTwelve(showtime.getShowTimes()) + " at " + showtime.getDate();
		request.setAttribute("ShowTime", showTimeStr);
		String seatStr = "Seat ";
		String seatEnc = "";
		for(int i = 0; i<seats.size(); i++)
		{
			if(seats.get(i) == true)
			{
				int seatNumber = i+1;
				seatStr += Integer.toString(seatNumber) + ", ";
				seatEnc += Integer.toString(seatNumber) + ",";
			}
		}
		seatStr = seatStr.substring(0, seatStr.length()-1);
		//Ticket ticket = new Ticket(7.50, 11.50, 9.50);
		double total = (tc.getAdultCount() * ticket.getAdultTicketCost()) + (tc.getSeniorCount() * ticket.getSeniorTicketCost()) + (tc.getChildCount() * ticket.getChildTicketCost());
		String totalCost = "$" + String.format("%.2f", total);
		request.setAttribute("aT", tc.getAdultCount());
		request.setAttribute("sT", tc.getSeniorCount());
		request.setAttribute("cT", tc.getChildCount());
		request.setAttribute("seatingID", seat.getSeatingId());
		request.setAttribute("Seats", seatStr);
		request.setAttribute("seatsEnc", seatEnc);
		request.setAttribute("Total", totalCost);
		request.setAttribute("CardEnding", sessionData.getCurrentSessionUser().getCard().getCardEnding());
		request.setAttribute("showtimeId", showtime.getID());
	}
	public void setOrderConfirmationPage(HttpServletRequest request, HttpServletResponse response, Order order)
	{
		sessionController sc = new sessionController();
		sc.navigatePage(request, response, "OrderConfirmationPage.jsp");
		return;
	}
	public void setAdminUserSearchPage(HttpServletRequest request, HttpServletResponse response, String userSearch)
	{
		List<WebUser> list = Database.getAllUsers();
		//System.out.println("ADMIN SEARCH: " + userSearch + " | ADMIN FOUND COUNT: " + list.size());
		
		String html = "";
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).getSessionType().equals("admin"))
			{
				continue;
			}else if(list.get(i).getFullName().toLowerCase().contains(userSearch.toLowerCase())) {
				html += generateHTMLController.adminUserSearchBody(list.get(i));
			}
		}
		if(html.equals(""))
		{
			request.setAttribute("userList", "<p style=\"color: red; text-align: center; font-size: 1.5rem;\">NO USERS FOUND</p>");
		}else {
			request.setAttribute("userList", html);
		}
	}
}
