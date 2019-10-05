import UserData.*;
// Inheritance class for user functions and objects
public class Users
{
    private String firstName;
    private String lastName;
    //private String password;
    //private String email;
    //private String phoneNumber;
    //private String birthDate;
    private Card card;
    
    public Users(String fName, String lName)
    {
        firstName = fName;
        lastName = lName;
    }
    public void setFirstName(String fName)
    {
        firstName = fName;
    }
    public void setLastName(String lName)
    {
        lastName = lName;
    }
    public void setPaymentCard(Card C)
    {
        card = C;
    }

    //GETTERS
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    public Card getPaymentCard()
    {
        return card;
    }
}