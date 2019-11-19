package eCommerce.MovieData;

public class TicketCount {

	private int aCount;
	private int sCount;
	private int cCount;
	private int total;
	
	public TicketCount(int Senior_Count, int Adult_Count, int Child_Count)
	{
		aCount = Adult_Count;
		sCount = Senior_Count;
		cCount = Child_Count;
		total = Adult_Count + Senior_Count + Child_Count;
	}
	public int getAdultCount()
	{
		return aCount;
	}
	public int getSeniorCount()
	{
		return sCount;
	}
	public int getChildCount()
	{
		return cCount;
	}
	public int totalCount()
	{
		return total;
	}
}
