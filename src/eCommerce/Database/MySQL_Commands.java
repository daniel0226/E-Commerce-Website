package eCommerce.Database;

public class MySQL_Commands {
	public static final String Add_Movie =
			"INSERT INTO movies(moviePicture, movieTrailerUrl, movieTitle, movieCategory, movieDirector, movieProducer, movieSynopsis, movieRating, movieExpDate, movieReleaseDate)" + 
			" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String Get_All_Movies = "SELECT * FROM termproject.movies";
	
	public static final String Get_Movie ="SELECT * FROM termproject.movies WHERE movieTitle = ";
}
