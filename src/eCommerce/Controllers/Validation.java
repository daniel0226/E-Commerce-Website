package eCommerce.Controllers;

public class Validation
{
    public boolean validateLoginCredentials(String email, String password)
    {
        //Connect to Database
        //Either through database object class <-- Preferably
        //or manual connection
        String testUser = "daniel";
        String testPassword = "12345";
        if(testUser.equals(email) && testPassword.equals(password))
        {
            return true;
        }else
        {
            return false;
        }
    }
}