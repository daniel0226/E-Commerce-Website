package eCommerce.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.MovieData.Promotions;
import eCommerce.UserData.Card;

class databaseTest {

	@Test
	public void test() throws SQLException {
		
		//Database should be null without initializing.
		assertEquals(Database.getDatabase(), null);
		
		//Test database initializing
		new Database();
		assertNotEquals(Database.getDatabase(), null);
		
		//Test Get Card
		assertEquals(Database.getCard("daniel1996k@icloud.com").getCardName(), "Daniel Kim");
		
		//Test Get All Users
		assertNotEquals(Database.getAllUsers(), null);
		
		//Test Get User
		assertNotEquals(Database.getUser("daniel1996k@icloud.com"), null);
		
		//Test Get Movie
		Movie movie = Database.getMovie("Joker");
		assertEquals(movie.getMovieTitle(), "Joker");
		
		Database.addMovieReview("Joker", "test", "test user");
		assertNotEquals(Database.getMovieReviews(movie), null);
		
		//Test Get Promotion
		Promotions p = Database.getPromotion("8");
		assertNotEquals(p, null);
		
		//Test Get All Promotions
		List<Promotions> list = Database.getAllPromotions();
		assertNotEquals(list, null);
	}

}
