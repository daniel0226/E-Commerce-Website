package eCommerce.Controllers;

import java.sql.SQLException;
import java.util.List;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;

public class test {
	public void test2()
	{
		if(Database.getDatabase() == null)
		{
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			List<Movie> inTheatres = Database.getMoviesFromDatabase(true,false);
			if(inTheatres.size() != 0)
			{
				String html = "";
				for(int i = 0; i<inTheatres.size(); i++)
				{
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
