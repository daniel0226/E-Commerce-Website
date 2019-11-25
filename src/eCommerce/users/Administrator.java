package eCommerce.users;

public class Administrator extends Users
{
	private String sessionType = "admin";
	private String PhoneNumber;

	public Administrator(String fName, String lName, String Password, String Email, String phoneNumber)
	{
		super(fName, lName, Password, Email);
		PhoneNumber = phoneNumber; 
	}
	
	public String getSessionType()
	{
		return sessionType;
	}
	public String getPhoneNumber()
	{
		return PhoneNumber;
	}

}