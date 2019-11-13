package eCommerce.MovieData;

public class ShowTimes {

	private String movieTitle;
	private int theatreNum;
	private String showtime;
	private String date;
	private int id;
	
	public ShowTimes(String title, int cinemaID, String times_Delimited, String Date)
	{
		movieTitle = title;
		theatreNum = cinemaID;
		showtime = times_Delimited;
		date = Date;
	}
	public ShowTimes(String title, int cinemaID, String times_Delimited, String Date, int ID)
	{
		movieTitle = title;
		theatreNum = cinemaID;
		showtime = times_Delimited;
		date = Date;
		id = ID;
	}
	public int getID()
	{
		return id;
	}
	public String getDate()
	{
		return date;
	}
	
	public String getShowTimes()
	{
		return showtime;
	}
	public String getMovieTitle()
	{
		return movieTitle;
	}
	public int getCinemaID()
	{
		return theatreNum;
	}
}
