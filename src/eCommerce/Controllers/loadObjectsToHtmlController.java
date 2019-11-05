package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import eCommerce.MovieData.Movie;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.users.WebUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eCommerce.Database.*;

@WebServlet("/loadObjectsToHtmlController")
public class loadObjectsToHtmlController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private authenticatorController authenticator;

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
					request.getRequestDispatcher("/inTheatres.jsp").forward(request, response);
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
							String movieHTML = generateHTMLController.generateInTheatres(currentMovie);
							htmlcode += movieHTML;
						}
					}
					request.setAttribute("moviesInTheatresList", htmlcode);
					request.getRequestDispatcher("/comingSoon.jsp").forward(request, response);
					return;
				} catch (SQLException e) {
					e.printStackTrace();
					break;
				}
			case "searchMovies":
				// Need to implement
				request.getRequestDispatcher("/SearchView.jsp").forward(request, response);
				return;
			default:
				System.out.println("Tell me how you got to here you hacker :(.");
				return;
		}
	}
	
	public void setAdminPage(HttpServletRequest request, HttpServletResponse response, WebUser user)
	{
		try {
    		request.setAttribute("adminName", user.getFullName());
    		request.setAttribute("location", user.getAddress().getCity() + ", " + user.getAddress().getState());
			request.setAttribute("moviesInTheatres", Database.getMoviesFromDatabase(true, false).size());
        	request.setAttribute("moviesComingSoon", Database.getMoviesFromDatabase(false, true).size());
        	request.setAttribute("moviesArchived", Database.getMoviesArchivedCount());
    		request.setAttribute("mostPopularMovie", Database.getMostPopularMovie());
    		request.setAttribute("movieStats",Database.getMovieStats());
    		request.setAttribute("addMovies", Database.generateMovieHtml(Database.getAllMovies()));
    		
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
    	try {
			request.getRequestDispatcher("/profilePage.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setEditPage(HttpServletRequest request, HttpServletResponse response, WebUser user) throws ServletException, IOException
	{
		Address address = user.getAddress();
    	Card card = Database.getCard(user.getEmail());
    	request.setAttribute("name", user.getFullName());
    	
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
		
		//Address
		request.setAttribute("addressLine", address.getAddressLine());
		request.setAttribute("city", address.getCity());
		request.setAttribute("state", address.getState());
		request.setAttribute("country", address.getCountry());
		request.setAttribute("billingZipCode", address.getZipCode());
    	request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
    	return;
	}
}
