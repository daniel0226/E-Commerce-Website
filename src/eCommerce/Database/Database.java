package eCommerce.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import eCommerce.Validator.Validator;
import eCommerce.Controllers.authenticatorController;
import eCommerce.Controllers.generateHTMLController;
import eCommerce.MovieData.*;
import eCommerce.UserData.Card;
import eCommerce.users.WebUser;

public class Database {
	
	private static authenticatorController authenticator;
	private static MysqlDataSource mysql = null;
	private static Connection connection = null;
	private static Statement statement = null;
	private String DB_URL = "jdbc:mysql://localhost/termproject";
	private String USER = "root";
	private String PASS = "12345Daniel";

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

	public void createDatabase() throws SQLException {

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
	
	public static Card getCard(String email)
	{
		Card userCard = null;
		try {
			String getMovieExecution = MySQL_Commands.Get_UserCard + "'" + email + "'";
			connection = mysql.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(getMovieExecution);
			if(rs.next())
			{
				userCard = new Card(rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6));
			}
		}catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not get user. Perhaps user doesn't exist");
		}
		return userCard;
	}

	public static WebUser getUser(String email)
	{
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
				user = new WebUser(	rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									getCard(email),
									rs.getBoolean(7),
									rs.getString(8),
									rs.getString(9),
									rs.getBoolean(10));
			}
			rs.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not get user. Perhaps user doesn't exist");
		}
		return user;
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
			statement.setString(3, card.getCVV());
			statement.setString(4, card.getExpirationDate());
			statement.setString(5, card.getCardNumber());
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
			statement.setString(3, authenticator.encryptPassword(user.getPassword()));
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getStrBirthday());
			statement.setBoolean(6, user.verified());
			statement.setString(7, user.getCode());
			statement.setString(8, user.getSessionType());
			statement.setBoolean(9, user.isReceivingPromoUpdates());
			statement.executeUpdate();
			statement.close();
			connection.close();
			addedUser = true;
		}catch (SQLException e) {
			System.err.println(e);
			System.err.println("Could not add Card. Perhaps the card already exists.");
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

	public List<Movie> getAllMovies() throws SQLException
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
									rs.getString(11));
			moviesList.add(movie);
		}
		rs.close();
		connection.close();
		return moviesList;
	}
	public List<Movie> getMoviesFromDatabase(boolean inTheatres, boolean comingSoon) throws SQLException {
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
									rs.getString(11));
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
	
	public static Movie getMovie(String movieName) throws SQLException
	{
		Movie movie = null;
		String getMovieExecution = MySQL_Commands.Get_Movie + "'" + movieName + "'";
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
								rs.getString(11));
		}
		rs.close();
		connection.close();
		return movie;
	}
	
	//Need to implement
	public String getMostPopularMovie() throws SQLException
	{
		Movie movie = getMovie("Joker");
		String html = generateHTMLController.mostPopularMovieHtml(movie);
		return html;
	}
	
	//Need to implement
	public String getMovieStats()
	{
		String movieStats = "<p>Joker#33</p>" + 
				"<p>Lion King#14</p>" +
				"<p>Gemini Man#12</p>" +
				"<p>Maleficent#21</p>" +
				"<p>The Addams Family#18</p>";
		return movieStats;
	}
	public String generateMovieHtml(List<Movie> list)
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
}
