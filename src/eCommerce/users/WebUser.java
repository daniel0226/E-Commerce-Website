package eCommerce.users;
import eCommerce.UserData.*;

public class WebUser extends Users
{
    private boolean suspended = false;

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
	
	public boolean isSuspended()
	{
		return suspended;
	}
	
	public void setSuspension()
	{
		suspended = true;
	}

}