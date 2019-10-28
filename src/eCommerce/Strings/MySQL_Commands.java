package eCommerce.Strings;

public class MySQL_Commands {
	
	//Movie related
	public static final String Add_Movie =
			"INSERT INTO movies(moviePicture, movieTrailerUrl, movieTitle, movieCategory, movieDirector, movieProducer, movieSynopsis, movieRating, movieExpDate, movieReleaseDate)" + 
			" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String Get_All_Movies = "SELECT * FROM termproject.movies";
	
	public static final String Get_Movie ="SELECT * FROM termproject.movies WHERE movieTitle = ";
	
	
	//User related
	public static final String Get_User = "SELECT * FROM termproject.users WHERE email = ";
	
	public static final String Get_UserCard = "SELECT * FROM termproject.card WHERE cardOwnerEmail = ";
	
	public static final String Add_User = 
			"INSERT INTO users (firstname, lastname, password, email, birthday, verified, verificationCode, session, promoUpdates, phonenumber, address)" + 
			" VALUES (? ,? ,? ,? ,? ,? ,? , ?, ?, ?, ?)";
	public static final String Add_Card =
			"INSERT INTO card (cardOwnerEmail, cardOwnerName, cvv, expDate, cardNumber, zipCode)" +
			" VALUES (?, ?, ?, ?, ?, ?)";
	public static String updateUser(String email)
	{
		String mysqlCommand = "UPDATE termproject.users SET verified = '1' WHERE email = '" + email + "';";
		return mysqlCommand;
	}
}
