package eCommerce.Controllers;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
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
import eCommerce.MovieData.Ticket;
import eCommerce.MovieData.TicketCount;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.email;
import eCommerce.UserData.Order;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/orderController")
public class orderController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void init()
	{
		try {
			if(Database.getDatabase() == null)
			{
				new Database();
			}
		}catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	public orderController()
	{
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String checkout = request.getParameter("checkout");
		String cancel = request.getParameter("cancel");
		
		EmailController Email = new EmailController();
		sessionController sc = new sessionController();
		
		if(cancel != null && !cancel.equals(""))
		{
			sc.navigatePage(request, response, "index.jsp");
			return;
		}
		if(checkout != null && !checkout.equals(""))
		{
			Seatings seat = Database.getSeats(checkout);
			TicketCount tc = new TicketCount(	Integer.parseInt(request.getParameter("senior")),
												Integer.parseInt(request.getParameter("adult")),
												Integer.parseInt(request.getParameter("child")));
			Ticket ticket = new Ticket(9.50, 11.50, 7.50);
			double total = (tc.getAdultCount() * ticket.getAdultTicketCost()) + (tc.getSeniorCount() * ticket.getSeniorTicketCost()) + (tc.getChildCount() * ticket.getChildTicketCost());
			WebUser user = sessionData.getCurrentSessionUser();
			ShowTimes showtime = Database.getShowTimeByID(checkout);
			String[] seatArr = request.getParameter("seatsEnc").split(",");
			List<Integer> seats = new LinkedList<>();
			for(String s : seatArr)
			{
				seats.add(Integer.parseInt(s));
			}
			Order order = new Order(	user.getEmail(), Integer.parseInt(checkout), seat.getSeatingId(),
										tc, total, seats);
			Database.addOrder(order);
			Database.updateSeats(order);
			Email.sendEmail(user, email.orderConfirmed, email.orderConfirmationMsg);
			Database.resetDatabase();
			loadObjectsToHtmlController loadHtml = new loadObjectsToHtmlController();
			loadHtml.setOrderConfirmationPage(request, response, order);
			return;
			//Update seatings
			//Update orders
		}
	}
	
}