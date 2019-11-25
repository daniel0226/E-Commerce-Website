package eCommerce.UserData;

import eCommerce.Controllers.authenticatorController;
import eCommerce.Controllers.dateController;

public class Card
{
    private String  cardName;
    private String  CVV;
    private String  expirationDate;
    private String  cardNumber;
    private String	zipCode;
    private authenticatorController control;
    private dateController date;

    public Card(String cName, String cvv, String expDate, String cNumber, String uZipcode)
    {
    	//If user left card field blank, these string values will be ""
        cardName = cName;
        CVV = cvv;
        expirationDate = expDate;
        cardNumber = cNumber;
        zipCode = uZipcode;
        control = new authenticatorController();
        date = new dateController();
    }
    public Card()
    {
    	cardName = "";
        CVV = "";
        expirationDate = "";
        cardNumber = "";
        zipCode = "";
        control = new authenticatorController();
        date = new dateController();
    }
    public String getCardMonth()
    {
    	return date.getCardMonth(expirationDate);
    }
    public String getCardEnding()
    {
		return control.getCardEnding(cardNumber);
    }
    public String getCardYear()
    {
    	return date.getCardYear(expirationDate);
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