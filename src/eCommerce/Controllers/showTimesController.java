package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.MovieData.ShowTimes;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/showTimesController")
public class showTimesController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("Show Times Controller has been instantiated.");
		if(Database.getDatabase() == null)
		{
			try {
				Database db = new Database();
				System.out.println(db.databaseConnected());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String add = request.getParameter("showtimeSubmit");
		String edit = request.getParameter("edit");
		String delete = request.getParameter("delete");
		int cinemaID = Integer.parseInt(request.getParameter("cinemaID"));
		String time = request.getParameter("time");
		String date = request.getParameter("date");
		String oldtime = request.getParameter("ot");
		
		if(delete != null)
		{
			Movie movie = Database.getMovie(delete);
			int id = Integer.parseInt(request.getParameter("id"));
			ShowTimes st = new ShowTimes(movie.getMovieTitle(), cinemaID, time, date, id);
			Database.removeShowTime(st);
			Database.resetDatabase();
			loadObjectsToHtmlController lh = new loadObjectsToHtmlController();
			request.setAttribute("ErrorMsg", "<p>Successfully removed ShowTime</p>");
			request.setAttribute("js", generateHTMLController.navigateDiv("showtimeBtn","Showtimes"));
			lh.setAdminPage(request, response, sessionData.getCurrentSessionUser());
			return;
		}
		
		if(edit != null)
		{
			Movie movie = Database.getMovie(edit);
			loadObjectsToHtmlController lh = new loadObjectsToHtmlController();
			int id = Integer.parseInt(request.getParameter("id"));
			ShowTimes st = new ShowTimes(movie.getMovieTitle(), cinemaID, time, date, id);
			if(!Validator.isValidateShowTime(st, oldtime))
			{
				request.setAttribute("ErrorMsg", "<p style=\"color: red;\">Could not update Show Time. Invalid inputs.</p>");
				request.setAttribute("js", generateHTMLController.navigateDiv("showtimeBtn","Showtimes"));
				lh.setAdminPage(request, response, sessionData.getCurrentSessionUser());
				return;
			}
			Database.updateShowTime(st);
			Database.resetDatabase();
			request.setAttribute("ErrorMsg", "<p>Successfully updated ShowTime</p>");
			request.setAttribute("js", generateHTMLController.navigateDiv("showtimeBtn","Showtimes"));
			lh.setAdminPage(request, response, sessionData.getCurrentSessionUser());
			return;
		}
		
		if(add != null)
		{
			Movie movie = Database.getMovie(add);
			loadObjectsToHtmlController lh = new loadObjectsToHtmlController();
			ShowTimes st = new ShowTimes(movie.getMovieTitle(), cinemaID, time, date);
			if(!Validator.isValidateShowTime(st, oldtime))
			{
				request.setAttribute("ErrorMsg", "<p = style\"color: red;\">Could not add Show Time. Invalid inputs.</p>");
				request.setAttribute("js", generateHTMLController.navigateDiv("showtimeBtn","Showtimes"));
				lh.setAdminPage(request, response, sessionData.getCurrentSessionUser());
				return;
			}
			Database.addShowTime(st);
			Database.resetDatabase();
			request.setAttribute("ErrorMsg", "<p>Successfully updated ShowTime</p>");
			request.setAttribute("js", generateHTMLController.navigateDiv("showtimeBtn","Showtimes"));
			lh.setAdminPage(request, response, sessionData.getCurrentSessionUser());
			return;
		}
	}
}