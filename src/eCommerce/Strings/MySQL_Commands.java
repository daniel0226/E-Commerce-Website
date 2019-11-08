package eCommerce.Strings;

import eCommerce.Controllers.authenticatorController;
import eCommerce.MovieData.Movie;
import eCommerce.UserData.Card;
import eCommerce.users.WebUser;

public class MySQL_Commands {

	// Movie related
	public static final String Add_Movie = "INSERT INTO movies(moviePicture, movieTrailerUrl, movieTitle, movieCategory, movieDirector, movieProducer, movieSynopsis, movieRating, movieExpDate, movieReleaseDate, cast)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String Get_All_Movies = "SELECT * FROM termproject.movies";

	public static final String Get_Movie = "SELECT * FROM termproject.movies WHERE movieTitle = ";

	public static final String Remove_Movie = "DELETE FROM termproject.movies WHERE movieTitle = ";
	public static final String Update_Archived_Movies_Count = 
			"UPDATE termproject.analytics SET moviesArchived = moviesArchived + 1 WHERE moviesArchived = moviesArchived;";
	public static final String Get_Movie_Archived_Count =
			"SELECT moviesArchived FROM termproject.analytics";
	
	// User related
	public static final String Get_User = "SELECT * FROM termproject.users WHERE email = ";

	public static final String Get_UserCard = "SELECT * FROM termproject.card WHERE cardOwnerEmail = ";

	public static final String Add_User = "INSERT INTO users (firstname, lastname, password, email, birthday, verified, verificationCode, session, promoUpdates, phonenumber, address)"
			+ " VALUES (? ,? ,? ,? ,? ,? ,? , ?, ?, ?, ?)";
	public static final String Add_Card = "INSERT INTO card (cardOwnerEmail, cardOwnerName, cvv, expDate, cardNumber, zipCode)"
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	
	public static String getMoviesByTitle(String title)
	{
		return "SELECT * FROM termproject.movies WHERE movieTitle LIKE '%" + title + "%'";
	}
	public static String getMoviesByCategory(String category)
	{
		return "SELECT * FROM termproject.movies WHERE movieCategory LIKE '%" + category + "%'";
	}

	public static String updateCard(WebUser user, Card card) {
		authenticatorController control = new authenticatorController();
		String number = control.encryptString(card.getCardNumber());
		String cvv = control.encryptString(card.getCVV());
		return "UPDATE termproject.card SET cardOwnerName = '" + card.getCardName() + "', zipCode = '"
				+ card.getZipCode() + "', cvv = '" + cvv + "', `expDate` = '" + card.getExpirationDate()
				+ "', `cardNumber` = '" + number + "' WHERE cardOwnerEmail = '" + user.getEmail() + "';";
	}
	public static String updateMovie(Movie movie, String db_Title)
	{
		String synopsis = movie.getMovieSynopsis().replaceAll("'", "''");
		return "UPDATE termproject.movies SET moviePicture = '" + movie.getMoviePicture() + "', movieTrailerUrl = '"
				+ movie.getMovieTrailer() + "', movieTitle = '" + movie.getMovieTitle() + "', `movieCategory` = '" + movie.getMovieCategory()
				+ "', `movieDirector` = '" + movie.getMovieDirector() + "', `movieProducer` = '" + movie.getMovieProducer() + 
				"', `movieSynopsis` = '" + synopsis + "', `movieRating` = '" + movie.getMovieRating() + 
				"', `movieExpDate` = '" + movie.getMovieExpDate() + "', `movieReleaseDate` = '" + movie.getMovieReleaseDate() + "', `cast` = '" + movie.getMovieCast() + "' WHERE movieTitle = '" + db_Title + "';";
	}

	public static String updateUser(String email) {
		String mysqlCommand = "UPDATE termproject.users SET verified = '1' WHERE email = '" + email + "';";
		return mysqlCommand;
	}

	public static String updatePassword(String email, String password) {
		String mysqlCommand = "UPDATE termproject.users SET password = '" + password + "' WHERE email = '" + email
				+ "';";
		return mysqlCommand;
	}

	public static String updateAddress(String email, String addressEn) {
		String mysqlCommand = "UPDATE termproject.users SET address = '" + addressEn + "' WHERE email = '" + email
				+ "';";
		return mysqlCommand;
	}

	public static String updateAbout(String email, String f, String l, String t, boolean p) {
		int myInt = p ? 1 : 0;
		return "UPDATE termproject.users SET firstname = '" + f + "', lastname = '" + l + "',`promoUpdates` = '" + myInt
				+ "', `phonenumber` = '" + t + "' WHERE email = '" + email + "';";
	}
}
