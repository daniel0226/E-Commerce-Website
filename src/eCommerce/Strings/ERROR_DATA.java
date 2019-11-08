package eCommerce.Strings;

public class ERROR_DATA {

	public static final String NOT_UNIQUE_EMAIL =
			"<p class=\"errorMessage\">Associated E-Mail Address already has an account!</p>" +
			"<a href=\"forgetPassword.html\">Forgot Password?</a>";
	
	public static final String PAYMENT_METHOD_FILLED_ERROR =
			"<p class=\"errorMessage\">Please fill out all payment method fields!</p>";

	public static final String ADDRESS_FILLED_ERROR =
			"<p class=\"errorMessage\">Please fill out all address fields!</p>";
	public static final String INVALID_LOGIN_ERROR =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
            "Invalid Email Address or Password.</p>";
	public static final String USER_HAS_NOT_VERIFIED_EMAIL =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
		    "Email has not been verified. Please verify email.</p>"+
		    "<a href=\"resendEmail.jsp\">Resend Verification</a>";
	public static final String MOVIE_ALREADY_EXISTS =
			"<p style=\"color:red; margin: 0; text-align: center; padding: 0;\">" + 
            "Movie already exists in Database";
	public static final String MOVIE_DOES_NOT_EXIST = 
			"<p style=\"color:red; margin: 0; text-align: center; padding: 0;\">" + 
            "We could not find that Movie!";
	public static final String BANNED =
			"<p style=\"color:red; margin: 0; text-align: center; padding: 0;\">" + 
		    "You have been suspended. Please contact an administrator ";
	public static final String LOGIN_FIRST_ERROR =
			"<p style=\"color:red; margin: 0; text-align: center; padding: 0;\">" + 
			"Please login first.";
	public static final String INVALID_EMAIL =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
            "Email Address was not found!</p>";
	public static final String INVALID_PASSWORD =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
		            "Password did not match our records!</p>";
	public static final String NOT_UNIQUE_PASSWORD =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
		            "Password cannot be same as previous password!</p>";
	public static final String LOGOUT_FIRST =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
		            "Please logout first!</p>";
			
}
