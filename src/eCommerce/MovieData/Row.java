package eCommerce.MovieData;

public class Row {
	private boolean seat1;
	private boolean seat2;
	private boolean seat3;
	private boolean seat4;
	private boolean seat5;
	
	public Row(boolean s1, boolean s2, boolean s3, boolean s4, boolean s5)
	{
		seat1 = s1;
		seat2 = s2;
		seat3 = s3;
		seat4 = s4;
		seat5 = s5;
	}
	public Row()
	{
		seat1 = false;
		seat2 = false;
		seat3 = false;
		seat4 = false;
		seat5 = false;
	}
	
	public boolean getSeat1()
	{
		return seat1;
	}
	
	public boolean getSeat2()
	{
		return seat2;
	}
	public boolean getSeat3()
	{
		return seat3;
	}
	public boolean getSeat4()
	{
		return seat4;
	}
	public boolean getSeat5()
	{
		return seat5;
	}
}
