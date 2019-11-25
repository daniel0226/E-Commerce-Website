package eCommerce.Validator;
import eCommerce.Controllers.dateController;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.MovieData.Promotions;
import eCommerce.MovieData.ShowTimes;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.users.WebUser;
import eCommerce.Controllers.authenticatorController;
import static java.time.temporal.ChronoUnit.HOURS;
public class Validator
{
	private static authenticatorController authenticator;
	private static long MAX_DIFFERENCE = 2;
	
	public static boolean isValidateShowTime(ShowTimes st, String oldTime)
	{
		System.out.println("Validating Show Time");
		boolean validShowTime = true;
		//Check date first
		List<ShowTimes> st_l = Database.getAllShowTimes();
		if(st_l == null)
		{
			validShowTime = true;
		}else {
			List<LocalTime> tC = new LinkedList<LocalTime>();
			//System.out.println(st.getMovieTitle() + " " + st.getCinemaID() + " " + st.getShowTimes() + " " + st.getDate());
			for(int i = 0; i<st_l.size(); i++)
			{
				ShowTimes currentST = st_l.get(i);
				//System.out.println(currentST.getMovieTitle() + " " + currentST.getCinemaID() + " " + currentST.getShowTimes() + " " + currentST.getDate());
				if(currentST.getCinemaID() == st.getCinemaID())
				{
					if(currentST.getDate().equals(st.getDate()))
					{
						if(!currentST.getShowTimes().equals(oldTime))
						{
							tC.add(LocalTime.parse(currentST.getShowTimes()));	
						}
					}
				}
			}
			if(tC.size() == 0)
			{
				validShowTime = true;
			}else
			{ 
				tC.add(LocalTime.parse(st.getShowTimes()));
				Collections.sort(tC);
				for(int i = 1; i<tC.size(); i++)
				{
					long Difference = Math.abs(tC.get(i).until(tC.get(i-1), HOURS));
					if(Difference < MAX_DIFFERENCE)
					{
						validShowTime = false;
					}
				}
			}
		}
		return validShowTime;
	}
	public static boolean validateUserHasVerified(String email)
	{
		return Database.getUser(email).verified();
	}
    public static boolean validateLoginCredentials(String email, String password)
    {
        authenticator = new authenticatorController();
        WebUser user = Database.getUser(email);
        if(user == null) 
        {
        	return false;
        }
        
        return password.equalsIgnoreCase(authenticator.decryptString(user.getPassword()));
        
    }
   
    public static boolean validateRegistrationEmailIsUnique(String email)
    {
    	return Database.getUser(email) == null;
    }

    public static boolean validateAllPaymentFieldsAreSet(String cardHolderName, String cardNumber, String CVV, String zipcode)
    {
		boolean allFieldsFilled = false;
		String[] strArr = new String[]{cardHolderName, cardNumber, CVV, zipcode};
		
		int emptyCount = 0;
		for(int i = 0; i<strArr.length; i++)
		{
			if(strArr[i].equals(""))
			{
				emptyCount++;
			}
		}
		//If all the fields are empty (Payment is optional, so this is ok
		if(emptyCount == 4)
		{
			allFieldsFilled = true;
		//If none of the fields are empty
		}else if(emptyCount == 0)
		{
			allFieldsFilled = true;
		}
		
		return allFieldsFilled;
    }
    public static boolean promotionIsUnique(Double discount)
    {
    	List<Promotions> list = Database.getAllPromotions();
    	if(list == null || list.size() == 0)
    	{
    		return true;
    	}else
    	{
    		for(int i = 0; i<list.size(); i++)
    		{
    			if(list.get(i).getDiscountAmount() == discount)
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    public static boolean validateUserHasCardOnFile(WebUser user)
    {
    	Card card = user.getCard();
    	if(card == null)
    	{
    		return false;
    	}
    	else if(card.getCardName() == null || card.getCardName().equals(""))
    	{
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    public static boolean userHasConfirmedLogin(String email)
    {
    	return Database.getUser(email).verified();
    }
    public static boolean userIsSuspended(String email)
    {
    	WebUser user = Database.getUser(email);
    	return user.getSessionType().equals("suspended");
    }
    
    public static boolean dateIsPassedToday(String date)
    {
    	return dateController.dateIsGreaterThanToday(date);
    }
    
    public static boolean movieAlreadyExists(Movie movie) throws SQLException
    {
    	return Database.getMovie(movie.getMovieTitle()) != null;
    }
    public static boolean validateMovieInTheatres(Movie movie)
    {
    	return dateController.movieIsInTheatres(movie);
    }
    public static boolean validateMovieComingSoon(Movie movie)
    {
    	return dateController.movieIsComingSoon(movie);
    }
    public static boolean validateUserIsLoggedIn()
    {
    	return sessionData.getCurrentSessionUser() != null;
    }
}