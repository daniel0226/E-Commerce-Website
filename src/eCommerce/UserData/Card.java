package eCommerce.UserData;

import eCommerce.Controllers.authenticatorController;

public class Card
{
    private String  cardName;
    private String  CVV;
    private String  expirationDate;
    private String  cardNumber;
    private String	zipCode;

    public Card(String cName, String cvv, String expDate, String cNumber, String uZipcode)
    {
    	//If user left card field blank, these string values will be ""
        cardName = cName;
        CVV = cvv;
        expirationDate = expDate;
        cardNumber = cNumber;
        zipCode = uZipcode;
    }
    public String getCardMonth()
    {
    	String[] dates = {"", ""};
    	if(expirationDate != null || expirationDate != "")
    	{
    		dates = expirationDate.split("-");
    	}
    	return dates[0];
    }
    public String getCardEnding()
    {

		authenticatorController control = new authenticatorController();
		System.out.println(control.decryptString(cardNumber) + " " + control.decryptString(cardNumber).length()
		if(control.decryptString(cardNumber).length() > 4)
		{
    		String end = control.decryptString(cardNumber);
    		return end.substring(end.length()-4, end.length());
    	}else
    	{
    		return "";
    	}
    }
    public String getCardYear()
    {
    	String[] dates = {"", ""};
    	if(expirationDate != null || expirationDate != "")
    	{
    		dates = expirationDate.split("-");
    	}
    	return dates[1];
    }
    public String getCardName()
    {
        return cardName;
    }
    public String getCVV()
    {
        return CVV;
    }
    public String getExpirationDate()
    {
        return expirationDate;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }
    public String getZipCode()
    {
    	return zipCode;
    }
}