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
	private String cast;
	
	public Movie(String Picture, String Trailer, String Title, String Category, String Director, String Producer, String Synopsis, String rating, String expDate, String releaseDate, String Cast)
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
		cast = Cast;
	}
	
	public String getMovieCast()
	{
		return cast;
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
