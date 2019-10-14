package eCommerce.Controllers;
import java.util.HashMap;
import java.util.Map;

public class Validator
{
    public static boolean validateLoginCredentials(String email, String password)
    {
        //Connect to Database
    	//
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
    public static boolean validateRegistrationEmailIsUnique(String email)
    {
    	boolean isUnique = true;
    	//Connect to Database
    	//Check if email exists
    	return isUnique;
    }
    public static boolean validateAllPaymentFieldsAreSet(String cardHolderName, String cardNumber, String CVV, String zipcode)
    {
		boolean allFieldsFilled = false;
		String[] strArr = new String[]{cardHolderName, cardNumber, CVV, zipcode};
		
		int emptyCount = 0;
		for(int i = 0; i<strArr.length; i++)
		{
			if(strArr[i].equals(""))
			{
				emptyCount++;
			}
		}
		//If all the fields are empty (Payment is optional, so this is ok
		if(emptyCount == 4)
		{
			allFieldsFilled = true;
		//If none of the fields are empty
		}else if(emptyCount == 0)
		{
			allFieldsFilled = true;
		}
		
		return allFieldsFilled;
    }
    
    public static boolean userHasConfirmedLogin(String email)
    {
    	boolean isConfirmed = false;
    	//connect to DB
    	//Check if user is confirmed.
    	return isConfirmed;
    }
    public static boolean userIsSuspended(String email)
    {
    	boolean isSuspended = false;
    	//connect to DB
    	//Check if user is suspended.
    	return isSuspended;
    }
}