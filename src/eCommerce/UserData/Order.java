package eCommerce.UserData;

import java.util.List;

import eCommerce.MovieData.TicketCount;

public class Order
{
	private int id;
	private String Email;
	private int showTimeID;
	private int seatingID;
	private TicketCount TC;
	private double total;
	public List<Integer> Seats;
	
	public Order(	int ID, String email, int showtime_ID, int seating_ID,
					TicketCount tc, double Total, List<Integer> seatIds)
	{
		id = ID;
		Email = email;
		showTimeID = showtime_ID;
		seatingID = seating_ID;
		TC = tc;
		total = Total;
		Seats = seatIds;
	}
	public Order(String email, int showtime_ID, int seating_ID,
			TicketCount tc, double Total, List<Integer> seatIds)
	{
		id = -1;
		Email = email;
		showTimeID = showtime_ID;
		seatingID = seating_ID;
		TC = tc;
		total = Total;
		Seats = seatIds;
	}
	public int getOrderID()
	{
		return id;
	}
	public String getEmail()
	{
		return Email;
	}
	public int getShowTimeID()
	{
		return showTimeID;
	}
	public int getSeatingID()
	{
		return seatingID;
	}
	public TicketCount getTickets()
	{
		return TC;
	}
	public double getTotal()
	{
		return total;
	}
	public String getTotalString()
	{
		return "$" + String.format("%.2f", total);
	}
	public List<Integer> getSeatArray()
	{
		return Seats;
	}
	
}