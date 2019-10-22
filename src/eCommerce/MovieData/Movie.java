package eCommerce.MovieData;
public class Movie {
	
	private String moviePicture;
	private String movieTrailer;
	private String movieTitle;
	private String movieCategory;
	private String movieDirector;
	private String movieProducer;
	private String movieSynopsis;
	private String movieRating;
	private String movieExpDate;
	private String movieReleaseDate;
	
	
	public Movie(String Picture, String Trailer, String Title, String Category, String Director, String Producer, String Synopsis, String rating, String expDate, String releaseDate)
	{
		moviePicture = Picture;
		movieTrailer = Trailer;
		movieTitle = Title;
		movieCategory = Category;
		movieDirector = Director;
		movieProducer = Producer;
		movieSynopsis = Synopsis;
		movieRating = rating;
		movieExpDate = expDate;
		movieReleaseDate = releaseDate;
	}
	
	public String getMoviePicture()
	{
		return moviePicture;
	}
	
	public String getMovieTrailer()
	{
		return movieTrailer;
	}
	public String getMovieTitle()
	{
		return movieTitle;
	}
	public String getMovieCategory()
	{
		return movieCategory;
	}
	public String getMovieDirector()
	{
		return movieDirector;
	}
	public String getMovieProducer()
	{
		return movieProducer;
	}
	public String getMovieSynopsis()
	{
		return movieSynopsis;
	}
	public String getMovieRating()
	{
		return movieRating;
	}
	public String getMovieExpDate()
	{
		return movieExpDate;	
	}
	public String getMovieReleaseDate()
	{
		return movieReleaseDate;
	}
}
