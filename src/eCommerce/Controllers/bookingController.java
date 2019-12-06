package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.Database;
import eCommerce.MovieData.Movie;
import eCommerce.MovieData.Seatings;
import eCommerce.MovieData.ShowTimes;
import eCommerce.MovieData.TicketCount;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/bookingController")
public class bookingController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static sessionController sessionC;

	public void init() {
		System.out.println("Booking Controller has been instantiated.");
		Database.validateDatabase(Database.getDatabase());
		sessionC = new sessionController();
	}
	public bookingController()
	{
		super();
		sessionC = new sessionController();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String movieToBook = request.getParameter("book");
		String requestID = request.getParameter("type");
		String date = request.getParameter("date");
		String ticket = request.getParameter("submitTicket");
		String book = request.getParameter("bookShowTime");
		
		if(sessionData.getCurrentSession() == null)
		{
			sessionController sc = new sessionController();
			request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
			sc.navigatePage(request, response, "/login.jsp");
			return;
		}
		//Returns movie title
		
		if(!Validator.validateUserIsLoggedIn())
		{
			request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
			sessionC.navigatePage(request, response, "/login.jsp");
            return;
		}
		
		if(book != null && !book.equals(""))
		{
			bookMovie(request, response, book);
		}
		
		if(ticket != null && !ticket.equals(""))
		{
			ticketQuery(request, response, ticket);
		}
		
		if(date != null && !date.equals(""))
		{
			selectingQuery(request, response, date);
		}
		
		if(requestID != null && !requestID.equals(""))
		{
			queryTypes(request, response, requestID);
			return;
		}
		
		if(movieToBook != null && !movieToBook.equals(""))
		{
			bookingQuery(request, response, movieToBook);
			return;
		}
		
		return;
	}
	public void bookMovie(HttpServletRequest request, HttpServletResponse response, String id)
	{
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		sessionController sc = new sessionController();
		String[] seats = request.getParameterValues("seat");
		String showTimeID = request.getParameter("bookShowTime");
		ShowTimes showtime = Database.getShowTimeByID(showTimeID);
		Seatings seat_obj = Database.getSeats(showTimeID);
		TicketCount tc = new TicketCount(	Integer.parseInt(request.getParameter("senior")),
											Integer.parseInt(request.getParameter("adult")),
											Integer.parseInt(request.getParameter("child")));
		//System.out.print(tc.getAdultCount() + " " + tc.getSeniorCount() + " " + tc.getChildCount());
		
		List<Boolean> seatArray = new LinkedList<>();
		System.out.println(seatArray.size());
		List<String> seatIds = new ArrayList<>();
		int seatsClicked = 0;
		for(int i = 0; i<seats.length; i++)
		{
			if(Integer.parseInt(seats[i]) != -1)
			{
				seatArray.add(true);
				//Returns clicked ID's
				seatIds.add(seats[i]);
				System.out.println("Seat ID: " + seats[i]);
				seatsClicked++;
			}else {
				seatArray.add(false);
			}
		}
		if(Integer.parseInt(request.getParameter("max")) != seatsClicked)
		{
			Seatings s = Database.getSeats(id);
			ShowTimes st = Database.getShowTimeByID(Integer.toString(s.getShowTimeId()));
			Movie movie = Database.getMovie(st.getMovieTitle());
			//loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
			loadHtml.setTicketPage(request, response, movie, st);
			request.setAttribute("errorMsg", "<p style=\"text-align: center; color:red;\">Number of seats selected does not match tickets.</p>");
			sc.navigatePage(request, response, "selectTicket.jsp");
			return;
		}else
		{
			WebUser user = sessionData.getCurrentSessionUser();
			if(!Validator.validateUserHasCardOnFile(user))
			{
				request.setAttribute("errorMsg", "<p style=\"text-align: center; color:red;\">Please add a Payment Option to your account.</p>");
				sc.navigatePage(request, response, "editProfile.jsp");
			}
			loadHtml.setOrderSummary(request, response, tc, showtime, seatArray, seat_obj);
			sc.navigatePage(request, response, "OrderSummaryView.jsp");
			//Order summary -> checkout -> Check if card on file -> Order confirmation
			//->Edit Profile by adding order history
		}
	}
	public void ticketQuery(HttpServletRequest request, HttpServletResponse response, String id)
	{
		sessionController sc = new sessionController();
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		TicketCount tc = new TicketCount(	Integer.parseInt(request.getParameter("senior")),
											Integer.parseInt(request.getParameter("adult")),
											Integer.parseInt(request.getParameter("child")));
		if(tc.totalCount() == 0)
		{
			ShowTimes st = Database.getShowTimeByID(id);
			Movie movie = Database.getMovie(st.getMovieTitle());
			loadHtml.setTicketPage(request, response, movie, st);
			request.setAttribute("errorMsg", "<p style=\"text-align: center; color:red;\">Please select a quantity.</p>");
			sc.navigatePage(request, response, "selectTicket.jsp");
			return;
		}
		Database.resetDatabase();
		Seatings seats = Database.getSeats(id);
		loadHtml.setSeatingPage(request, response, tc, seats);
		sc.navigatePage(request, response, "selectSeats.jsp");
	}
	public void selectingQuery(HttpServletRequest request, HttpServletResponse response, String id)
	{
		sessionController sc = new sessionController();
		if(sessionData.getCurrentSession() == null)
		{
			request.setAttribute("loginError", ERROR_DATA.LOGIN_FIRST_ERROR);
			sc.navigatePage(request, response, "/login.jsp");
			return;
		}
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		ShowTimes st = Database.getShowTimeByID(id);
		Movie movie = Database.getMovie(st.getMovieTitle());
		loadHtml.setSelectShowTimesPage(request, response, movie, st.getDate());
		sc.navigatePage(request, response, "selectView.jsp");
	}
	
	public void bookingQuery(HttpServletRequest request, HttpServletResponse response, String movieTitle)
	{
		sessionController sc = new sessionController();
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		Movie movie = Database.getMovie(movieTitle);
		loadHtml.setDateSelect(request, response, movie);
		sc.navigatePage(request, response, "selectView.jsp");
	}
	
	public void queryTypes(HttpServletRequest request, HttpServletResponse response, String id)
	{
		ShowTimes st = Database.getShowTimeByID(id);
		sessionController sc = new sessionController();
		loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
		Movie movie = Database.getMovie(st.getMovieTitle());
		loadHtml.setTicketPage(request, response, movie, st);
		sc.navigatePage(request, response, "selectTicket.jsp");
	}
}
