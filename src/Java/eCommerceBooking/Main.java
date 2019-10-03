package eCommerceBooking;

import eCommerceBooking.users.*;
import eCommerceBooking.UserData.*;

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