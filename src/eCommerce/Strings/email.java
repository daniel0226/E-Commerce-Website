package eCommerce.Strings;

public class email {

	//Subjects
	public final static String regConfirm = "Confirm Registration.";
	public final static String newPassword = "New Password";
	public final static String forgotPassword = "Forgot Password";
	public final static String updateProfile = "Your Profile has Been Updated.";
	
	//Messages
	public final static String confirmMsg = "Congratulations you have successfully registered!";
	public final static String reconfirmMsg = "Reconfirm your profile by clicking here: ";
	public final static String forgetPassMsg = "We have sent this email in response to forgetting your password." + 
	" Your password is: ";
	public final static String updatedPasswordMsg ="This message is to update your recent password change. " +
	"Your password has been successfully updated.";
	
	public static final String confirmationSent =
			"<p style=\"color:white; margin: 0; text-align: center; padding: 0;\">" + 
			"Email confirmation sent. Please check your email.";
	public static final String forgotPasswordSent = 
			"<p style=\"color:white; margin: 0; text-align: center; padding: 0;\">" + 
			"Your password was sent to your corresponsing email. Please check your email.";
}
