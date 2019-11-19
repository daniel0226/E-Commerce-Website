package eCommerce.MovieData;

public class Seatings {

	private Row row1;
	private Row row2;
	private Row row3;
	private Row row4;
	private Row row5;
	
	public Seatings(Row r1, Row r2, Row r3, Row r4, Row r5)
	{
		row1 = r1;
		row2 = r2;
		row3 = r3;
		row4 = r4;
		row5 = r5;
	}
	public Seatings()
	{
		Row row = new Row();
		row1 = row;
		row2 = row;
		row3 = row;
		row4 = row;
		row5 = row;
	}
	public Row getrow1()
	{
		return row1;
	}
	public Row getrow2()
	{
		return row2;
	}
	public Row getrow3()
	{
		return row3;
	}
	public Row getrow4()
	{
		return row4;
	}
	public Row getrow5()
	{
		return row5;
	}
}
