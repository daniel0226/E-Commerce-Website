package eCommerce.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import eCommerce.Validator.Validator;
import eCommerce.Controllers.authenticatorController;
import eCommerce.Controllers.dateController;
import eCommerce.MovieData.*;
import eCommerce.Strings.MySQL_Commands;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.users.WebUser;

public class Database {
	
	private static authenticatorController authenticator;
	private static MysqlDataSource mysql = null;
	private static Connection connection = null;
	private static Statement statement = null;
	private static WebUser currentUser = null;
	
	public Database() throws SQLException {
		try {
			authenticator = new authenticatorController();
			Class.forName("com.mysql.cj.jdbc.Driver");
			mysql = new MysqlDataSource();
			createDatabase();
			System.out.println("Database connection established.");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	public static void setDatabaseToNull()
	{
		mysql = null;
		connection = null;
		statement = null;
		currentUser = null;
	}
	public static void resetDatabase()
	{
		try
		{
			setDatabaseToNull();
			Class.forName("com.mysql.cj.jdbc.Driver");
			mysql = new MysqlDataSource();
			createDatabase();
			System.out.println("New Database connection established.");
		}catch(SQLException e)
		{
			System.err.println(e);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void createDatabase() throws SQLException {

		mysql.setServerName("localhost");
		mysql.setPort(3306);
		mysql.setDatabaseName("termproject");
		mysql.setUser("root");
		mysql.setPassword("12345Daniel");
		mysql.setServerTimezone("EST");
	}

	public static MysqlDataSource getDatabase() {
		return mysql;
	}
	
	public static void updateCard(Card card, WebUser user)
	{
		try
		{
			System.out.println("Updating " + user.getEmail() + "'s payment information.");
			String updateCardExecution = MySQL_Commands.updateCard(user, card);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updateCardExecution);
			statement.executeUpdate();
			statement.close();
			connection.close();
			return;
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	public static void updateProfile(WebUser user, String firstName, String lastName, String phoneNumber, boolean receivePromo)
	{
		try
		{
			System.out.println("Updating " + user.getEmail() + "'s about information.");
			String updateProfileExecution = MySQL_Commands.updateAbout(user.getEmail(), firstName, lastName, phoneNumber, receivePromo);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updateProfileExecution);
			statement.executeUpdate();
			statement.close();
			connection.close();
			return;
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	public static void updateAddress(Address address, WebUser user)
	{
		try
		{
			System.out.println("Updating " + user.getEmail() + "'s address information.");
			String updateAddressExecution = MySQL_Commands.updateAddress(user.getEmail(), address.getAddressEnc());
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updateAddressExecution);
			statement.executeUpdate();
			statement.close();
			connection.close();
			return;
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	public static void updatePassword(WebUser user, String Password)
	{
		try
		{
			System.out.println("Updating " + user.getEmail() + "'s password.");
			String updatePasswordExecution = MySQL_Commands.updatePassword(user.getEmail(), authenticator.encryptString(Password));
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updatePasswordExecution);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	public static void updateMovie(Movie movie, Movie oldMovie)
	{
		try
		{
			System.out.println("Updating " + movie.getMovieTitle() + "'s movie information.");
			String updateMovieExecution = MySQL_Commands.updateMovie(movie, oldMovie.getMovieTitle());
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updateMovieExecution);
			statement.executeUpdate();
			statement.close();
			connection.close();
			System.out.println("Successfully updated movie: " + movie.getMovieTitle());
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public static Card getCard(String email)
	{
		Card userCard = null;
		try {
			System.out.println("Getting " + email + "'s card from Database.");
			String getMovieExecution = MySQL_Commands.Get_UserCard + "'" + email + "'";
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(getMovieExecution);
			if(rs.next())
			{
				userCard = new Card(rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7));
			}
		}catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not get card. Perhaps the card doesn't exist");
		}
		return userCard;
	}

	public static void confirmUser(WebUser user)
	{
		try {
			System.out.println("Verifying user: " + user.getEmail());
			String confirmUserCommand = MySQL_Commands.updateUser(user.getEmail());
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(confirmUserCommand);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch (SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public static WebUser getUser(String email)
	{
		if(currentUser != null && currentUser.getEmail().equals(email))
		{
			System.out.println("User already initialized. Returning " + email);
			return currentUser;
		}
		WebUser user = null;
		try
		{
			System.out.println("Getting " + email + " from Database.");
			String getMovieExecution = MySQL_Commands.Get_User + "'" + email + "'";
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(getMovieExecution);
			if(rs.next())
			{
				Address address = new Address(rs.getString(12));
				user = new WebUser(	rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									getCard(email),
									rs.getBoolean(7),
									rs.getString(8),
									rs.getString(9),
									rs.getBoolean(10),
									rs.getString(11),
									address);
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not get user. Perhaps user doesn't exist");
		}
		currentUser = user;
		return user;
	}
	
	public static List<movieReviews> getMovieReviews(Movie movie)
	{
		List<movieReviews> reviewsList = new LinkedList<>();
		try
		{
			String getMovieReviews = MySQL_Commands.movieReviews(movie);
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(getMovieReviews);
			while(rs.next())
			{
				movieReviews reviews = new movieReviews(rs.getString(2),
														rs.getString(3),
														rs.getString(4),
														rs.getString(5));
				reviewsList.add(reviews);
			}
		}catch(SQLException e)
		{
			System.err.println(e);
		}
		return reviewsList;
	}
	
	public static void addMovieReview(String title, String review, String usersName)
	{
		dateController dc = new dateController();
		try {
			System.out.println(usersName + " has added movie review to: " + title);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(MySQL_Commands.addMovieReview);
			statement.setString(1, title);
			statement.setString(2, review);
			statement.setString(3, usersName);
			statement.setString(4, dc.getTodaysDate());
			statement.executeUpdate();
			statement.close();
			connection.close();
			return;
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public static boolean addCard(String email, Card card)
	{
		boolean addedCard = false;
		try {
			System.out.println("Adding " + card.getCardName() + "'s card to Database.");
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(MySQL_Commands.Add_Card);
			statement.setString(1, email);
			statement.setString(2, card.getCardName());
			statement.setString(3, authenticator.encryptString(card.getCVV()));
			statement.setString(4, card.getExpirationDate());
			statement.setString(5, authenticator.encryptString(card.getCardNumber()));
			statement.setString(6, card.getZipCode());
			statement.executeUpdate();
			statement.close();
			connection.close();
			addedCard = true;
		}catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not add Movie. Perhaps the movie already exists.");
		}
		return addedCard;
	}
	public static boolean addWebUser(WebUser user)
	{
		boolean addedUser = false;
		try {
			System.out.println("Adding " + user.getFullName() + " to Database.");
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(MySQL_Commands.Add_User);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, authenticator.encryptString(user.getPassword()));
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getStrBirthday());
			statement.setBoolean(6, user.verified());
			statement.setString(7, user.getCode());
			statement.setString(8, user.getSessionType());
			statement.setBoolean(9, user.isReceivingPromoUpdates());
			statement.setString(10, user.getPhoneNumber());
			statement.setString(11, user.getAddress().getAddressEnc());
			statement.executeUpdate();
			statement.close();
			connection.close();
			addedUser = true;
		}catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not add User. Perhaps the card already exists.");
		}
		return addedUser;
	}
	public static void addMovie(Movie movie) {
		try {
			System.out.println("Adding movie to Database.");
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(MySQL_Commands.Add_Movie);
			statement.setString(1, movie.getMoviePicture());
			statement.setString(2, movie.getMovieTrailer());
			statement.setString(3, movie.getMovieTitle());
			statement.setString(4, movie.getMovieCategory());
			statement.setString(5, movie.getMovieDirector());
			statement.setString(6, movie.getMovieProducer());
			statement.setString(7, movie.getMovieSynopsis());
			statement.setString(8, movie.getMovieRating());
			statement.setString(9, movie.getMovieExpDate());
			statement.setString(10, movie.getMovieReleaseDate());
			statement.executeUpdate();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not add User. Perhaps the User already exists.");
		}
	}
	
	public static ShowTimes getShowTimeByID(String id)
	{
		try {
		ShowTimes st = null;
		String query = "SELECT * FROM termproject.showtime WHERE id = " + id;
		connection = mysql.getConnection();
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next())
		{
			st = new ShowTimes(	rs.getString(2),
					rs.getInt(3),
					rs.getString(4),
					rs.getString(5),
					rs.getInt(1));
		}
		rs.close();
		connection.close();
		return st;
		}catch(SQLException e)
		{
			System.err.print(e);
			return null;
		}
	}

	public static List<Movie> getMoviesByCategory(String category) throws SQLException
	{
		List<Movie> moviesList = new LinkedList<Movie>();
		String query = MySQL_Commands.getMoviesByCategory(category);
		connection = mysql.getConnection();
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next())
		{
			Movie movie = new Movie(rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12));
			moviesList.add(movie);
		}
		rs.close();
		connection.close();
		return moviesList;
	}
	public static int getNumberOfShowingsCount()
	{
		HashSet<String> movies = new HashSet<String>();
		try {
			String query = "SELECT * FROM termproject.showtime";
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				ShowTimes showtime = new ShowTimes(	rs.getString(2),
													rs.getInt(3),
													rs.getString(4),
													rs.getString(5),
													rs.getInt(1));
				movies.add(showtime.getMovieTitle());
			}
			return movies.size();
		}catch(SQLException e)
		{
			System.err.println(e);
			return 0;
		}
	}
	public static int getMovieShowTimesCount()
	{
		int count = 0;
		try {
			String query = "SELECT * FROM termproject.showtime";
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				ShowTimes showtime = new ShowTimes(	rs.getString(2),
													rs.getInt(3),
													rs.getString(4),
													rs.getString(5),
													rs.getInt(1));
				
				count++;
			}
			return count;
		}catch(SQLException e)
		{
			System.err.println(e);
			return 0;
		}
	}
	public static void updateShowTime(ShowTimes st)
	{
		try {
			String updateShowTime = MySQL_Commands.updateShowTime(st);
			System.out.println(updateShowTime);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updateShowTime);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e)
		{
			System.err.print(e);
		}
	}
	public static void addShowTime(ShowTimes st)
	{
		try
		{
			String a_ST = MySQL_Commands.ADD_SHOWTIME(st);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(a_ST);
			statement.setString(1, st.getMovieTitle());
			statement.setInt(2, st.getCinemaID());
			statement.setString(3, st.getShowTimes());
			statement.setString(4, st.getDate());
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e)
		{
			System.err.print(e);
		}
	}
	public static void removeShowTime(ShowTimes st)
	{
		try {
			String removeShowTime = MySQL_Commands.REMOVE_SHOWTIME(st);
			System.out.println(removeShowTime);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(removeShowTime);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e)
		{
			System.err.print(e);
		}
	}
	public static List<ShowTimes> getAllShowTimes()
	{
		try {
			List<ShowTimes> list = new LinkedList<ShowTimes>();
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM termproject.showtime");
			while(rs.next())
			{
				ShowTimes showtime = new ShowTimes(	rs.getString(2),
													rs.getInt(3),
													rs.getString(4),
													rs.getString(5),
													rs.getInt(1));
				list.add(showtime);
			}
			return list;
		}catch(SQLException e)
		{
			System.err.println(e);
			return null;
		}
	}
	public static List<ShowTimes> getMovieShowTimes(Movie movie)
	{
		try {
			System.out.println("Getting Show Times for Movie: " + movie.getMovieTitle());
			List<ShowTimes> moviesShowTimeList = new LinkedList<ShowTimes>();
			String query = MySQL_Commands.getShowTimes(movie);
			System.out.println(query);
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) 
			{
				ShowTimes showtime = new ShowTimes(	rs.getString(2),
													rs.getInt(3),
													rs.getString(4),
													rs.getString(5),
													rs.getInt(1));
				moviesShowTimeList.add(showtime);
			}
			return moviesShowTimeList;
			
		}catch(SQLException e)
		{
			System.err.println(e);
			return null;
		}
	}
	
	public static List<Movie> getMoviesbyTitle(String title) throws SQLException
	{
		List<Movie> moviesList = new LinkedList<Movie>();
		String query = MySQL_Commands.getMoviesByTitle(title);
		connection = mysql.getConnection();
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next())
		{
			Movie movie = new Movie(rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12));
			moviesList.add(movie);
		}
		rs.close();
		connection.close();
		return moviesList;
	}
	
	public static List<Movie> getAllMovies() throws SQLException
	{
		List<Movie> moviesList = new LinkedList<Movie>();
		String getAllMovies = MySQL_Commands.Get_All_Movies;
		connection = mysql.getConnection();
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(getAllMovies);
		while(rs.next())
		{
			Movie movie = new Movie(rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12));
			moviesList.add(movie);
		}
		rs.close();
		connection.close();
		return moviesList;
	}
	public static List<Movie> getMoviesFromDatabase(boolean inTheatres, boolean comingSoon) throws SQLException {
		List<Movie> moviesList = new LinkedList<Movie>();
		String getAllMovies = MySQL_Commands.Get_All_Movies;
		connection = mysql.getConnection();
		statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(getAllMovies);
		while(rs.next())
		{
			Movie movie = new Movie(rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12));
			if(inTheatres)
			{
				if(Validator.validateMovieInTheatres(movie))
				{
					System.out.println(movie.getMovieTitle() + " is in theatres.");
					moviesList.add(movie);
				}
			}else if(comingSoon)
			{
				if(Validator.validateMovieComingSoon(movie))
				{
					System.out.println(movie.getMovieTitle() + " is coming soon.");
					moviesList.add(movie);
				}
			}else
			{
				moviesList.add(movie);
			}
		}
		rs.close();
		connection.close();
		return moviesList;
	}

	public static Movie getMovie(String movieName)
	{
		Movie movie = null;
		System.out.println("Getting Movie: " + movieName + " from Database.");
		String getMovieExecution = MySQL_Commands.Get_Movie + "'" + movieName + "'";
		try {
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(getMovieExecution);
			if(rs.next())
			{
				movie = new Movie(	rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12));
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}
	
	//Need to implement
	public static String getMostPopularMovie() throws SQLException
	{
		Movie movie = getMovie("Joker");
		String html = generateHTMLController.mostPopularMovieHtml(movie);
		return html;
	}
	
	//Need to implement
	// FUTURE NOTES: 
	//When we add movie database
	//And showtime database
	//Keep track of how many sales of certain movie
	//Syntax is MovieTitle#NumOfTicketsSold
	//Javascript will parse into string arr by splitting using char '#'
	//movieTitle = arr[0]
	//NumOfTicketsSold = arr[1]
	public static String getMovieStats()
	{
		String movieStats = "<p>Joker#33</p>" + 
				"<p>Lion King#14</p>" +
				"<p>Gemini Man#12</p>" +
				"<p>Maleficent#21</p>" +
				"<p>The Addams Family#18</p>";
		return movieStats;
	}
	public static void removeMovie(String movieTitle)
	{
		System.out.println("Deleting: " + movieTitle + " from the database.");
		String removeMovie = MySQL_Commands.Remove_Movie + "'" + movieTitle + "'";
		System.out.println(removeMovie);
		String updateArchiveCount = MySQL_Commands.Update_Archived_Movies_Count;
		try {
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(removeMovie);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e){
			System.err.print(e);
		}
		try {
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(updateArchiveCount);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e){
			System.err.print(e);
		}
		return;
	}
	public static String generateMovieHtml(List<Movie> list)
	{
        String htmlcode = "";
        if(!list.isEmpty())
        {
        	for(int i = 0; i<list.size(); i++)
        	{
        		Movie currentMovie = list.get(i);
        		String movieHTML = generateHTMLController.generateAdminPageMoviesList(currentMovie);
        		htmlcode += movieHTML;
        	}
        }
        return htmlcode;
	}
	public static int getMoviesArchivedCount()
	{
		int count = 0;
		try {
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(MySQL_Commands.Get_Movie_Archived_Count);
			if(rs.next())
			{
				count = rs.getInt(1);
			}
		}catch(SQLException e)
		{
			System.err.println(e);
		}
		return count;
	}
	public String databaseConnected()
	{
		return "Connected";
	}
	public static ShowTimes getLastShowTime()
	{
		ShowTimes st = null;
		try {
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(MySQL_Commands.GET_LAST_SHOWTIME_ROW);
			if(rs.next())
			{
				st = new ShowTimes(	rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(1));
			}
			rs.close();
			connection.close();
			return st;
		}catch(SQLException e)
		{
			System.err.println(e);
			return null;
		}
	}
	public static void addSeatings(ShowTimes st)
	{
		ShowTimes a = Database.getLastShowTime();
		try
		{
			String addSeats = MySQL_Commands.ADD_SEATS(a);
			System.out.println(addSeats);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(addSeats);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e)
		{
			System.err.print(e);
		}
	}
	public static void removeSeatings(ShowTimes st)
	{
		try
		{
			String removeSeats = MySQL_Commands.REMOVE_SEATS(st);
			System.out.println(removeSeats);
			connection = mysql.getConnection();
			PreparedStatement statement = connection.prepareStatement(removeSeats);
			statement.executeUpdate();
			statement.close();
			connection.close();
		}catch(SQLException e)
		{
			System.err.print(e);
		}
	}
}
