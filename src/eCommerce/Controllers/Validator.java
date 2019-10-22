package eCommerce.Controllers;

import java.sql.SQLException;

import eCommerce.Database.*;
import eCommerce.MovieData.Movie;

public class Validator
{
    public static boolean validateLoginCredentials(String email, String password)
    {
    	//Get user from database
        String testUser = "daniel";
        String testPassword = "12345";
        //if(testUser.equals(email) && testPassword.equals(password))
        //{
        //   return true;
        //}else
        //{
        //    return false;
        //}
        return true;
    }
    public static boolean validateRegistrationEmailIsUnique(String email)
    {
    	boolean isUnique = true;
    	//Check if email exists
    	return isUnique;
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
    	boolean isConfirmed = false;
    	//Check if user is confirmed.
    	return isConfirmed;
    }
    public static boolean userIsSuspended(String email)
    {
    	boolean isSuspended = false;
    	//Check if user is suspended.
    	return isSuspended;
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
}