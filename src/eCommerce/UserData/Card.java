package eCommerce.UserData;
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