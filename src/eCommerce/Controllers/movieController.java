package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Error.ERROR_DATA;
import eCommerce.MovieData.Movie;
import eCommerce.debug.Debug;
 
@WebServlet("/movieController")
public class movieController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void init()
	{
		System.out.println("Movie Controller called");
	}
	public movieController()
	{
		super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {	
		String deleteButton = request.getParameter("deleteMoviesFromCheckBox");
		String addButton = request.getParameter("addBtn");
		String updateButton = request.getParameter("update");
		
		//String releaseDate = request.getParameter("releaseDate");
		//Only prints out if numbers are set
		//System.out.println(releaseDate);
		
		//If we add or delete movies, we have to update every page that displays movies.
		//For example, index page.
		
		//We received an add button request.
		if(addButton != null)
		{
			//System.out.println("add button called");
			Debug.debugAddMovie(request, response);
		}
		
		//We received an update movie request.
		if(updateButton != null)
		{
			return;
		}
		
		//We received a delete button request
		if(deleteButton != null)
		{
			//If checkboxes is selected, checkbox will print the value set in the HTML
			//For example: <input type="checkbox" value ="joker"> will print joker
			String[] Checkboxes = request.getParameterValues("movieCheckbox");
			if(Checkboxes.length == 0)
			{
				return;
			}
			
			//Remove all movies to Archive that are checked.
			for(int i = 0; i<Checkboxes.length; i++)
			{
				String currMovie = Checkboxes[i];
				
			}
			return;
		}
	}

}
