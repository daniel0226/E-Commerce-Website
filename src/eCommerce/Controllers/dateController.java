package eCommerce.Controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import eCommerce.MovieData.Movie;
import eCommerce.MovieData.ShowTimes;

public class dateController {
	
	//The way LocalDate.compareTo works is
	//If dates are equal, returns 0
	//if date is greater, returns positive number
	//If date is less than, retruns negative number
	public dateController()
	{
		
	}
	public String getTodaysDate()
	{
		return LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
	}
	public static boolean showTimeIsValidDate(ShowTimes st)
	{
		LocalDate todaysDate = LocalDate.now();
		LocalDate showDate = LocalDate.parse(st.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return todaysDate.compareTo(showDate) >= 0;
	}
	public static LocalDate convertToLocalDate(String date_str)
	{
		LocalDate date = LocalDate.parse(date_str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date;
	}
	public static boolean dateIsGreaterThanToday(String date)
	{
		LocalDate showtimeDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate todaysDate = LocalDate.now();
		if(showtimeDate.compareTo(todaysDate) >= 0)
		{
			return true;
		}else {
			return false;
		}

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
	public static String convertToTwelve(String time)
	{
		//param comes as 19:30 -> 7:30 pm
		return LocalTime.parse(time).format(DateTimeFormatter.ofPattern("h:mma"));
	}
	public static boolean dateIsToday(String date)
	{
		boolean isToday = false;
		String today = LocalDate.now().toString();
		String todaysDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
		if(today.equals(todaysDate))
		{
			isToday = true;
		}
		
		return isToday;
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
