package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import eCommerce.MovieData.Movie;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;
import eCommerce.Database.*;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		System.out.println("LoginController.java: Login was called");
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
	
	public LoginController()
	{
		super();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
        response.setContentType("html;charset=UTF-8");

        String emailLogin = request.getParameter("email");
        String passwordLogin = request.getParameter("password");
           
        //This returns "on" if checked
        //and null if not checked
        String rememberMeIsChecked = request.getParameter("rmCheckBox");
        if(rememberMeIsChecked != null)
        {
        	
        }
     
        //Login Checks
        //Password and password confirmation is checked in HTML
        //Session is checked in sessionController
        
        if(!Validator.validateLoginCredentials(emailLogin,passwordLogin))
        {
            request.setAttribute("loginError", ERROR_DATA.INVALID_LOGIN_ERROR);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        if(!Validator.userHasConfirmedLogin(emailLogin))
        {
        	request.setAttribute("loginError", ERROR_DATA.USER_HAS_NOT_VERIFIED_EMAIL);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        if(Validator.userIsSuspended(emailLogin))
        {
        	request.setAttribute("loginError", ERROR_DATA.BANNED);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        
        //If all is good
        //Create session
    	//HttpSession session = request.getSession();
    	//session.setAttribute("email", emailLogin);
    	
        WebUser user = Database.getUser(emailLogin);
        
        new sessionData(request, user);
        HttpSession session = sessionData.createSession();
        System.out.println("Welcome: " + (String)session.getAttribute("email"));
        if(user.getSessionType().equals("admin")) 
        {
        	try {
        		request.setAttribute("adminName", user.getFullName());
				request.setAttribute("moviesInTheatres", Database.getMoviesFromDatabase(true, false).size());
	        	request.setAttribute("moviesComingSoon", Database.getMoviesFromDatabase(false, true).size());
	        	request.setAttribute("moviesArchived", Database.getMoviesArchivedCount());
	    		request.setAttribute("mostPopularMovie", Database.getMostPopularMovie());
	    		request.setAttribute("movieStats",Database.getMovieStats());
	    		request.setAttribute("addMovies", Database.generateMovieHtml(Database.getAllMovies()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	request.getRequestDispatcher("/adminPage.jsp").forward(request, response);
        	return;
        }else if(user.getSessionType().equals("web"))
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
        	request.getRequestDispatcher("/profilePage.jsp").forward(request, response);
        	return;
        }
       
    }

}