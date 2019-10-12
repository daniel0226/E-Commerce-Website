package eCommerce.users;
import eCommerce.UserData.*;

public class WebUser extends Users
{
    //private boolean isSuspended = false;

	public WebUser(	String fName, 
					String lName, 
					String uPassword, 
					String uConPassword, 
					String uEmail, 
					String uBirthday,
					Card card)
	{
		super(fName, lName, uPassword, uConPassword, uEmail, uBirthday, card);
	}

}