package eCommerce.MovieData;

import java.time.LocalDate;
import eCommerce.Controllers.dateController;

public class Promotions {
	
	private int id;
	private String expirationDate;
	private double discountAmount;
	
	public Promotions(int ID, String date, double discount)
	{
		id = ID;
		expirationDate = date;
		discountAmount = discount;
	}
	
	public int getID()
	{
		return id;
	}
	public String getExpirationDate()
	{
		return expirationDate;
	}
	public double getDiscountAmount()
	{
		return discountAmount;
	}
	public LocalDate getLocalDateExpiratioNDate()
	{
		return dateController.convertToLocalDate(expirationDate);
	}
	
}
