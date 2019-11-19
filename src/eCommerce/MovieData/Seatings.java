package eCommerce.MovieData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Seatings {

	private Row row1;
	private Row row2;
	private Row row3;
	private Row row4;
	private Row row5;
	private int seatingId;
	private int showtimeId;
	private List<Boolean> list;
	
	public Seatings(Row r1, Row r2, Row r3, Row r4, Row r5, int sId, int shId)
	{
		row1 = r1;
		row2 = r2;
		row3 = r3;
		row4 = r4;
		row5 = r5;
		seatingId = sId;
		showtimeId = shId;
		list = new ArrayList<>();
		fillArr(row1);
		fillArr(row2);
		fillArr(row3);
		fillArr(row4);
		fillArr(row5);
		
	}
	public Seatings()
	{
		list = new ArrayList<>();
		Row row = new Row();
		row1 = row;
		row2 = row;
		row3 = row;
		row4 = row;
		row5 = row;
		seatingId = -1;
		showtimeId = -1;
		Collections.fill(list, Boolean.FALSE);
	}
	
	public void fillArr(Row row)
	{
		list.add(row.getSeat1());
		list.add(row.getSeat2());
		list.add(row.getSeat3());
		list.add(row.getSeat4());
		list.add(row.getSeat5());
	}
	
	public List<Boolean> getSeatArray()
	{
		return list;
	}
	public int getSeatingId()
	{
		return seatingId;
	}
	public int getShowTimeId()
	{
		return showtimeId;
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
