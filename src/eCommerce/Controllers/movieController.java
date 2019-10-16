package eCommerce.Controllers;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/movieController")
public class movieController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public movieController()
	{
		super();
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//If checkboxes is selected, checkbox will print the value set in the HTML
		//For example: <input type="checkbox" value ="joker"> will print joker
		String[] Checkboxes = request.getParameterValues("movieCheckbox");
		String deleteButton = request.getParameter("deleteMoviesFromCheckBox");
		String releaseDate = request.getParameter("releaseDate");
		//Only prints out if numbers are set
		System.out.println(releaseDate);
		
		if(deleteButton != null)
		{
			//Remove all movies to Archive that are checked.
			for(int i = 0; i<Checkboxes.length; i++)
			{
				String movie = Checkboxes[i];
				
			}
			return;
		}
		
		
	}

}
