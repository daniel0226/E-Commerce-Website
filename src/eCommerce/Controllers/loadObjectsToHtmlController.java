package eCommerce.Controllers;

import java.sql.SQLException;
import java.util.List;
import eCommerce.MovieData.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eCommerce.Database.*;

@WebServlet("/loadObjectsToHtmlController")
public class loadObjectsToHtmlController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() {
		if (Database.getDatabase() == null) {
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("html;charset=UTF-8");
		String requestType = request.getParameter("type");
		switch (requestType) 
		{
			case "inTheatres":
				try 
				{
					List<Movie> moviesInTheatresList = Database.getMoviesFromDatabase(true, false);
					String htmlcode = "";
					if (!moviesInTheatresList.isEmpty()) 
					{
						for (int i = 0; i < moviesInTheatresList.size(); i++) 
						{
							Movie currentMovie = moviesInTheatresList.get(i);
							String movieHTML = generateHTMLController.generateInTheatres(currentMovie);
							htmlcode += movieHTML;
						}
					}
					request.setAttribute("moviesInTheatresList", htmlcode);
					request.getRequestDispatcher("/inTheatres.jsp").forward(request, response);
					return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
			case "comingSoon":
				System.out.println("Coming");
				try {
					List<Movie> moviesInTheatresList = Database.getMoviesFromDatabase(false, true);
					String htmlcode = "";
					if (!moviesInTheatresList.isEmpty()) 
					{
						for (int i = 0; i < moviesInTheatresList.size(); i++) 
						{
							Movie currentMovie = moviesInTheatresList.get(i);
							String movieHTML = generateHTMLController.generateInTheatres(currentMovie);
							htmlcode += movieHTML;
						}
					}
					request.setAttribute("moviesInTheatresList", htmlcode);
					request.getRequestDispatcher("/comingSoon.jsp").forward(request, response);
					return;
				} catch (SQLException e) {
					e.printStackTrace();
					break;
				}
			case "searchMovies":
				// Need to implement
				request.getRequestDispatcher("/SearchView.jsp").forward(request, response);
				return;
			default:
				System.out.println("Tell me how you got to here you hacker :(.");
				return;
		}
	}
}
