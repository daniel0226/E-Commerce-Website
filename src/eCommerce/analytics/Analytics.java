package eCommerce.analytics;
import java.sql.SQLException;

import eCommerce.Database.*;

public class Analytics {
	
	public Analytics()
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
	
	public int getNumberOfPromotionAvailable()
	{
		return Database.getAllPromotions().size();
	}
	public int getNumberOfPromotionTransactions()
	{
		return Database.getPromoTransactions();
	}
	public int getPromosArchivedCount()
	{
		return Database.getPromoArchivedCount();
	}
}
