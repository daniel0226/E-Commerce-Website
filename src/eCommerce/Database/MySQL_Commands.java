package eCommerce.Database;

public class MySQL_Commands {
	public static final String Add_Movie =
			"insert into movies(moviePicture, movieTrailerUrl, movieTitle, movieCategory, movieDirector, movieProducer, movieSynopsis, movieRating, movieExpDate, movieReleaseDate)" + 
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
