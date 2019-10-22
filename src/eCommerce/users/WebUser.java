package eCommerce.users;

import eCommerce.UserData.*;

public class WebUser extends Users {
	private boolean suspended = false;
	// In database include session type, user/web/admin

	// User gets email after registration. Needs to confirm
	// In database, include a table whether user is confirmed or not.
	private String sessionType = "web";
	private boolean accountIsConfirmed;
	private String registrationCode;

	// When creating from Form
	public WebUser(String fName, String lName, String uPassword, String uConPassword, String uEmail, String uBirthday,
			Card card, boolean isConfirmed, String code) {
		super(fName, lName, uPassword, uConPassword, uEmail, uBirthday, card);
		accountIsConfirmed = isConfirmed;
		registrationCode = code;
	}

	// When creating as object
	public WebUser(String fName, String lName, String uPassword, String uEmail, String uBirthday, Card card, boolean isConfirmed, String code, String session)
	{
		super(fName, lName, uPassword,"",uEmail, uBirthday, card);
		accountIsConfirmed = isConfirmed;
		registrationCode = code;
	}

	public boolean verified()
	{
		return accountIsConfirmed;
	}
	public String getCode()
	{
		return registrationCode;
	}
	public String getSessionType()
	{
		return sessionType;
	}
}