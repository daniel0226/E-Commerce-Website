package eCommerce.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import eCommerce.MovieData.Movie;

public class dateController {
	
	//The way LocalDate.compareTo works is
	//If dates are equal, returns 0
	//if date is greater, returns positive number
	//If date is less than, retruns negative number
	public dateController()
	{
		
	}
	public static LocalDate convertToLocalDate(String date_str)
	{
		LocalDate date = LocalDate.parse(date_str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date;
	}
	public static boolean movieIsInTheatres(Movie movie)
	{
		boolean movieIsInTheatres = false;
		
		LocalDate todaysDate = LocalDate.now();
    	LocalDate movieRelease = LocalDate.parse(movie.getMovieReleaseDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	LocalDate movieEndDate = LocalDate.parse(movie.getMovieExpDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	
    	if(todaysDate.compareTo(movieRelease) >= 0 && todaysDate.compareTo(movieEndDate) < 0)
    	{
    		movieIsInTheatres = true;
    	}
    	return movieIsInTheatres;
	}
	
	public static boolean movieIsComingSoon(Movie movie)
	{
		boolean movieIsComingSoon = false;
		
		LocalDate todaysDate = LocalDate.now();
    	LocalDate movieRelease = LocalDate.parse(movie.getMovieReleaseDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	LocalDate movieEndDate = LocalDate.parse(movie.getMovieExpDate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
    	if(todaysDate.compareTo(movieRelease) < 0 && todaysDate.compareTo(movieEndDate) < 0)
    	{
    		movieIsComingSoon = true;
    	}
    	
    	return movieIsComingSoon;
	}
	public String getCardYear(String expirationDate)
	{
		String[] dates = {"", ""};
    	if(expirationDate != null || expirationDate != "")
    	{
    		dates = expirationDate.split("-");
    	}
    	return dates[1];
	}
	public String getCardMonth(String expirationDate)
	{
		String[] dates = {"", ""};
    	if(expirationDate != null || expirationDate != "")
    	{
    		dates = expirationDate.split("-");
    	}
    	return dates[0];
	}
}
