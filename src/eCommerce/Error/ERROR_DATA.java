package eCommerce.Error;

public class ERROR_DATA {

	public static final String NOT_UNIQUE_EMAIL =
			"<p class=\"errorMessage\">Associated E-Mail Address already has an account!</p>" +
			"<a href=\"forgetPassword.html\">Forgot Password?</a>";
	
	public static final String PAYMENT_METHOD_FILLED_ERROR =
			"<p class=\"errorMessage\">Please fill out all payment method fields!</p>";

	public static final String INVALID_LOGIN_ERROR =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
            "Invalid Email Address or Password.</p>";
	public static final String USER_HAS_NOT_VERIFIED_EMAIL =
			"<p style=\"color:red; margin: 0; padding: 0;\">" + 
		    "Email has not been verified. Please verify email.</p>"+
		    "<a href=\"sendVerificationEmail.html\">Resend Verification</a>";
	public static final String MOVIE_ALREADY_EXISTS =
			"<p style=\"color:red; margin: 0; text-align: center; padding: 0;\">" + 
            "Movie already exists in Database";
}
