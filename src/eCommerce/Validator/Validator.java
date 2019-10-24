package eCommerce.Validator;
import eCommerce.Controllers.dateController;

import java.sql.SQLException;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.users.WebUser;
import eCommerce.Controllers.authenticatorController;

public class Validator
{
	private static authenticatorController authenticator;
	
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
        byte[] passwordBytes = user.getPassword().getBytes();
        
        return password.equalsIgnoreCase(authenticator.decryptPassword(passwordBytes));
        
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
    
    public static boolean userHasConfirmedLogin(String email)
    {
    	return Database.getUser(email).verified();
    }
    public static boolean userIsSuspended(String email)
    {
    	WebUser user = Database.getUser(email);
    	return user.getSessionType().equals("suspended");
    }
    
    public static boolean movieAlreadyExists(Movie movie) throws SQLException
    {
    	boolean movieExists = false;
    	Movie duplicateMovie = Database.getMovie(movie.getMovieTitle());
    	
    	if(duplicateMovie != null) 
    	{
    		movieExists = true;
    	}
    	
    	if(duplicateMovie != null)
    	{
    		if(duplicateMovie.getMovieTitle().equalsIgnoreCase(movie.getMovieTitle()))
    		{
    			movieExists = true;
    		}
    		if(duplicateMovie.getMoviePicture().equalsIgnoreCase(movie.getMovieTitle()))
    		{
    			movieExists = true;
    		}
    		if(duplicateMovie.getMovieTrailer().equalsIgnoreCase(movie.getMovieTrailer()))
    		{
    			movieExists = true;
    		}
    	}
    	return movieExists;
    }
    public static boolean validateMovieInTheatres(Movie movie)
    {
    	return dateController.movieIsInTheatres(movie);
    }
    public static boolean validateMovieComingSoon(Movie movie)
    {
    	return dateController.movieIsComingSoon(movie);
    }
}