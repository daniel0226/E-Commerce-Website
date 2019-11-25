package eCommerce.Strings;

import java.util.List;

import eCommerce.Controllers.authenticatorController;
import eCommerce.MovieData.Movie;
import eCommerce.MovieData.ShowTimes;
import eCommerce.UserData.Card;
import eCommerce.UserData.Order;
import eCommerce.users.Administrator;
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
	public static final String UPDATE_PROMO_TRANSACTIONS =
			"UPDATE termproject.analytics SET promoTransaction = promoTransaction + 1;";
	public static final String UPDATE_PROMO_ARCHIVE_COUNT =
			"UPDATE termproject.analytics SET promosArchived = promosArchived + 1;";
	public static final String GET_ANALYTICS =
			"SELECT * FROM termproject.analytics";
	
	public static final String addMovieReview = "INSERT INTO moviereviews(title, review, user, date)" +
			" VALUES (?, ?, ?, ?)";
	public static final String GET_ALL_PROMOS = "SELECT * FROM termproject.promotions";
	
	// User related
	public static final String GET_ALL_USERS = "SELECT * FROM termproject.users";
	public static final String Get_User = "SELECT * FROM termproject.users WHERE email = ";

	public static final String Get_UserCard = "SELECT * FROM termproject.card WHERE cardOwnerEmail = ";

	public static final String Add_User = "INSERT INTO users (firstname, lastname, password, email, birthday, verified, verificationCode, session, promoUpdates, phonenumber, address)"
			+ " VALUES (? ,? ,? ,? ,? ,? ,? , ?, ?, ?, ?)";
	public static final String Add_Card = "INSERT INTO card (cardOwnerEmail, cardOwnerName, cvv, expDate, cardNumber, zipCode)"
			+ " VALUES (?, ?, ?, ?, ?, ?)";
	public static String GET_LAST_SHOWTIME_ROW = "SELECT * FROM termproject.showtime ORDER BY id DESC LIMIT 1";
	public static String GET_ALL_ADMINS = "SELECT * FROM termproject.employee";
	
	//Functions 
	public static String SUSPEND_USER(String email)
	{
		return "UPDATE termproject.users SET session = 'suspended' WHERE email = '" + email + "';";
	}
	public static String UNSUSPEND_USER(String email)
	{
		return "UPDATE termproject.users SET session = 'web' WHERE email = '" + email + "';";
	}
	public static String DELETE_USER(String email)
	{
		return "DELETE FROM termproject.users WHERE email = '" + email + "';";
	}
	public static String GET_ORDER(String email)
	{
		return "SELECT * FROM termproject.orders WHERE email = '" + email + "';";
	}
	public static String ADD_ADMIN(Administrator admin)
	{
		authenticatorController auth = new authenticatorController();
		return "INSERT INTO termproject.employee(firstName, lastName, email, password, phonenumber) VALUES "
				+ "('" + admin.getFirstName() + "','" + admin.getLastName() + "','" + admin.getEmail() + "','" + auth.encryptString(admin.getPassword())  + "','" + admin.getPhoneNumber() + "')";
	}
	public static String ADD_ORDER(Order order)
	{
		String seats = "";
		List<Integer> list = order.getSeatArray();
		for(int i = 0; i<list.size(); i++)
		{
			seats += list.get(i) + ",";
		}
		return "INSERT INTO termproject.orders(email,showTimeID,seatingID,adultCount,childCount,seniorCount,Total,Seats) VALUES "
				+ "('" +  order.getEmail() + "','" + order.getShowTimeID() + "','" + order.getSeatingID() + "','" + order.getTickets().getAdultCount() + "','" + order.getTickets().getChildCount() + "','" + order.getTickets().getSeniorCount() + "','" + order.getTotal()  + "','" + seats + "')";
	}
	
	public static String GET_PROMOTION(String ID)
	{
		return "SELECT * FROM termproject.promotions WHERE id = " + ID + ";";
	}
	public static String ADD_PROMOTION(String date, Double discount)
	{
		return "INSERT INTO termproject.promotions(expirationDate,discountAmount) VALUES ('" + date + "','" + discount + "')";
	}
	public static String GET_SEATS_BY_ID(String id)
	{
		return "SELECT * FROM termproject.seatings WHERE showtimeId = '" + id + "'";
	}
	public static String REMOVE_SEATS(ShowTimes st)
	{
		return "DELETE FROM termproject.seatings WHERE showtimeId = '" + st.getID() + "'";
	}
	public static String ADD_SEATS(ShowTimes st)
	{
		return "INSERT INTO termproject.seatings (showtimeId) VALUES ('" + st.getID() + "')";
	}
	public static String ADD_SHOWTIME(ShowTimes st)
	{
		return "INSERT INTO showtime(title, CinemaID, Showtime, Date)"
				+ " VALUES (?, ?, ?, ?)";
	}
	public static String REMOVE_SHOWTIME(ShowTimes st)
	{
		return "DELETE FROM termproject.showtime WHERE title = '" + st.getMovieTitle() + "' AND CinemaID = '" + st.getCinemaID() + "' AND Showtime = '" + st.getShowTimes() + "' AND Date = '" + st.getDate() + "'";
	}
	public static String getShowTimes(Movie movie)
	{
		return "SELECT * FROM termproject.showtime WHERE title = '" + movie.getMovieTitle() + "'";
	}
	public static String movieReviews(Movie movie)
	{
		return "SELECT * FROM termproject.moviereviews WHERE title = '" + movie.getMovieTitle() + "'";
	}
	
	public static String getMoviesByTitle(String title)
	{
		return "SELECT * FROM termproject.movies WHERE movieTitle LIKE '%" + title + "%'";
	}
	public static String getMoviesByCategory(String category)
	{
		return "SELECT * FROM termproject.movies WHERE movieCategory LIKE '%" + category + "%'";
	}
	public static String updateShowTime(ShowTimes st)
	{
		return "UPDATE termproject.showtime SET title= '" + st.getMovieTitle() + "', CinemaID = '" + st.getCinemaID() + "'" +
				", Showtime = '" + st.getShowTimes() + "', Date = '" + st.getDate() + "' WHERE (`id` = '" + st.getID() + "')";
	}
	public static String UPDATE_SEATS(Order order)
	{
		String set = " SET ";
		List<Integer> list = order.getSeatArray();
		for(int i = 0; i<list.size(); i++)
		{
			String seat = "seat" + list.get(i);
			String setStr = seat + " = " + "'0', ";
			set += setStr;
		}
		set = set.substring(0, set.length()-2);
		System.out.println(set);
		return "UPDATE termproject.seatings" + set + " WHERE (id = '" + order.getSeatingID() + "')";
	}

	public static String updateCard(WebUser user, Card card) {
		authenticatorController control = new authenticatorController();
		String number = control.encryptString(card.getCardNumber());
		String cvv = control.encryptString(card.getCVV());
		return "UPDATE termproject.card SET cardOwnerName = '" + card.getCardName() + "', zipCode = '"
				+ card.getZipCode() + "', cvv = '" + cvv + "', `expDate` = '" + card.getExpirationDate()
				+ "', `cardNumber` = '" + number + "' WHERE cardOwnerEmail = '" + user.getEmail() + "';";
	}
	public static String UPDATE_PROMOTION(String date, Double discount, String ID)
	{
		return "UPDATE termproject.promotions SET expirationDate = '" + date + "', discountAmount = '" + discount + "' WHERE id = " + ID + "";
	}
	public static String DELETE_PROMOTION(String ID)
	{
		return "DELETE FROM termproject.promotions WHERE id = " + ID + "";
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
