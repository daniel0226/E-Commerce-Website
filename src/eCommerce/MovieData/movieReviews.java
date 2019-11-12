package eCommerce.MovieData;

import java.time.LocalDate;

public class movieReviews {
	private String title;
	private String review;
	private String username;
	private String date;
	
	public movieReviews(String Title, String Review, String Username, String Date)
	{
		title = Title;
		review = Review;
		username = Username;
		date = Date;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getReview()
	{
		return review;
	}
	
	public String getUserName()
	{
		return username;
	}
}
