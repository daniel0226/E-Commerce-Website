package eCommerce.users;

import eCommerce.UserData.*;

public class WebUser extends Users {
	// User gets email after registration. Needs to confirm
	// In database, include a table whether user is confirmed or not.
	private String sessionType = "web";
	private boolean accountIsConfirmed;
	private String registrationCode;
	private boolean receivePromoEmailUpdates;
	private String phoneNumber = "";
	private Address address = null;
	
	// When creating from Form
	public WebUser(String fName, String lName, String uPassword, String uConPassword, String uEmail, String uBirthday,
			Card card, boolean isConfirmed, String code) {
		super(fName, lName, uPassword, uConPassword, uEmail, uBirthday, card);
		accountIsConfirmed = isConfirmed;
		registrationCode = code;
	}

	// When creating as object
	public WebUser(String fName, String lName, String uPassword, String uEmail, String uBirthday, Card card, boolean isConfirmed, String code, String session, boolean promoUpdates, String _phoneNumber, Address _address)
	{
		super(fName, lName, uPassword,"",uEmail, uBirthday, card);
		accountIsConfirmed = isConfirmed;
		registrationCode = code;
		receivePromoEmailUpdates = promoUpdates;
		sessionType = session;
		phoneNumber = _phoneNumber;
		address = _address;
	}

	public String getAddressString()
	{
		return address.toString();
	}
	public Address getAddress()
	{
		return address;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
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
	public boolean isReceivingPromoUpdates()
	{
		return receivePromoEmailUpdates;
	}
	public void setSuspension()
	{
		sessionType = "suspended";
	}
	public void setVerified()
	{
		accountIsConfirmed = true;
	}
}