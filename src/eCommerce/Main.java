package eCommerce;
import eCommerce.users.*;
import eCommerce.UserData.*;
import eCommerce.Controllers.*;

public class Main
{
    public static void main(String args[])
    {
        randomDebug();
    }
    public static void randomDebug()
    {
        Administrator Daniel = new Administrator("Daniel", "Kim");
        Card newCard = new Card("Daniel Kim", 123, "05/20", "123456789");
       
        Daniel.setPaymentCard(newCard);
        System.out.println(Daniel.getFullName());
        System.out.println(Daniel.getPaymentCard().getCardNumber());
    }
}