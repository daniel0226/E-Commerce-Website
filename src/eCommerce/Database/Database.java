package eCommerce.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import eCommerce.MovieData.*;

public class Database {

	private static MysqlDataSource mysql = null;
	private static Connection connection = null;
	private static Statement statement = null;
	private String DB_URL = "jdbc:mysql://localhost/termproject";
	private String USER = "root";
	private String PASS = "12345Daniel";

	public Database() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mysql = new MysqlDataSource();
			createDatabase();
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
			System.err.println("Could not add Movie. Perhaps the movie already exists.");
		}
	}

	public List<Movie> getMoviesFromDatabase() throws SQLException {
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
}
