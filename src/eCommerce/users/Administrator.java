package eCommerce.users;

import eCommerce.UserData.Card;

public class Administrator extends Users
{
	private String sessionType = "Admin";

	public Administrator(String fName, String lName, String uPassword, String uConPassword, String uEmail,
			String uBirthday, Card card) {
		super(fName, lName, uPassword, uConPassword, uEmail, uBirthday, card);
		// TODO Auto-generated constructor stub
	}
	
	public String getSessionType()
	{
		return sessionType;
	}

}