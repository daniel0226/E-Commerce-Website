package eCommerce.users;
import eCommerce.UserData.*;

public class WebUser extends Users
{
    private boolean suspended = false;
    private String sessionType = "web"; //In database include session type, user/web/admin
    
    //User gets email after registration. Needs to confirm
    //In database, include a table whether user is confirmed or not.
    private boolean accountIsConfirmed = false; 
    private int hashcode = 0; //Create hashcode into database maybe?

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
	
	public void setSuspension()
	{
		
	}
	public void setConfirmed(boolean confirmation)
	{
		accountIsConfirmed = confirmation;
	}
	public void removeSuspension()
	{
		
	}
	
	public boolean getConfirmed()
	{
		return accountIsConfirmed;
	}
	public boolean isSuspended()
	{
		return suspended;
	}
	public String getSessionType()
	{
		return sessionType;
	}

}