package eCommerce.UserData;
public class Card
{
    private String  cardName;
    private int     CVV;
    private String  expirationDate;
    private String  cardNumber;

    public Card(String cName, int cvv, String expDate, String cNumber)
    {
        cardName = cName;
        CVV = cvv;
        expirationDate = expDate;
        cardNumber = cNumber;
    }

    public Card()
    {
        //If user doesn't fill out payment method upon first registration
        cardName = "";
        CVV = 0;
        expirationDate = "";
        cardNumber = "";

    }

    public String getCardName()
    {
        return cardName;
    }
    public int getCVV()
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
}