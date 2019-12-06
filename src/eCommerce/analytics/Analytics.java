package eCommerce.analytics;
import java.sql.SQLException;

import eCommerce.Database.*;

public class Analytics {
	
	public Analytics()
	{
		Database.validateDatabase(Database.getDatabase());
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
