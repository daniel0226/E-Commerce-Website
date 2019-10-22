package eCommerce.Database;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import eCommerce.MovieData.*;

public class Database{
	
	private MysqlDataSource mysql;
	
	public Database() throws SQLException
	{
		mysql = new MysqlDataSource();
		createDatabase();
	}
	
	public void createDatabase() throws SQLException
	{

		mysql.setServerName("localhost");
        mysql.setPort(3306);
        mysql.setDatabaseName("csci4050");
        mysql.setUser("admin");
        mysql.setPassword("12345");
        mysql.setServerTimezone("EST");
	}
	
	public MysqlDataSource getDatabase()
	{
		return mysql;
	}
	
	public void addMovie(Movie movie)
	{
		 try {
	            Connection connection = mysql.getConnection();
	            PreparedStatement statement = connection.prepareStatement(MySQL_Commands.Add_Movie);
	            statement.setString(1, movie.getMoviePicture());
	            statement.setString(2, movie.getMovieTrailer());
	            statement.setString(3, movie.getMovieTitle());
	            statement.setString(4, movie.getMovieCategory());
	            statement.setString(5, movie.getMovieDirectory());
	            statement.setString(6, movie.getMovieProducer());
	            statement.setString(7, movie.getMovieSynopsis());
	            statement.setString(8, movie.getMovieRating());
	            statement.setString(9, movie.getMovieExpDate());
	            statement.setString(10, movie.getMovieReleaseDate());
	            statement.executeUpdate();
	            statement.close();
	            connection.close();
	        }
	        catch (SQLException e) {
	            System.err.println("User already created");
	        }
	}
	
	public List<Movie> getMoviesFromDatabase()
	{
		List<Movie> moviesList = new LinkedList<Movie>();
		
		return moviesList;
	}
}
