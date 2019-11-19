package eCommerce.MovieData;

import java.text.DecimalFormat;

public class Ticket {

	private double childTicket;
	private double adultTicket;
	private double seniorTicket;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public Ticket(double child, double adult, double senior)
	{
		childTicket = Double.parseDouble(df2.format(child));
		adultTicket = Double.parseDouble(df2.format(adult));
		seniorTicket = Double.parseDouble(df2.format(senior));
	}
	
	public double getChildTicketCost()
	{
		return childTicket;
	}
	public double getAdultTicketCost()
	{
		return adultTicket;
	}
	public double getSeniorTicketCost()
	{
		return seniorTicket;
	}
	public String childToString()
	{
		return "$" + String.format("%.2f", childTicket);
	}
	public String adultToString()
	{
		return "$" + String.format("%.2f", adultTicket);
	}
	public String seniorToString()
	{
		return "$" + String.format("%.2f", seniorTicket);
	}
}
