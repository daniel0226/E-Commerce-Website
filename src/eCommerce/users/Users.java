package eCommerce.users;
import eCommerce.Controllers.dateController;
import eCommerce.UserData.*;

import java.time.LocalDate;

// Inheritance class for user functions and objects
public class Users
{
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String emailAddress;
    private String birthday;
    private Card paymentCard;
    private LocalDate bday;
    
    public Users(	String fName, 
    				String lName, 
    				String uPassword, 
    				String uConPassword, 
    				String uEmail, 
    				String uBirthday,
    				Card card)
    {
    	
        firstName 		= fName;
        lastName 		= lName;
        password 		= uPassword;
        confirmPassword = uConPassword;
        emailAddress 	= uEmail;
        birthday 		= uBirthday;
        paymentCard 	= card;
        bday			= dateController.convertToLocalDate(birthday);
    }
    public Users(String fName, String lName, String Password, String Email)
    {
    	firstName = fName;
    	lastName = lName;
    	password = Password;
    	emailAddress = Email;
    	
    }
    public void setFirstName(String fName)
    {
        firstName = fName;
    }
    public void setLastName(String lName)
    {
        lastName = lName;
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
    public String getPassword()
    {
    	return password;
    }
    public String getEmail()
    {
    	return emailAddress;
    }
    public String getStrBirthday()
    {
    	return birthday;
    }
    public LocalDate getBirthday()
    {
    	return bday;
    }
    public Card getCard()
    {
    	return paymentCard;
    }

}