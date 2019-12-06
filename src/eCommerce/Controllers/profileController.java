package eCommerce.Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCommerce.Database.Database;
import eCommerce.Strings.ERROR_DATA;
import eCommerce.Strings.email;
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/profileController")
public class profileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private authenticatorController authenticator;
	private loadObjectsToHtmlController loadHtml;
	private sessionController sc;
	
	//This class only gets called if
	//sessionController validates that the user is logged in.
	public profileController()
	{
		super();
		loadHtml = new loadObjectsToHtmlController();
		authenticator = new authenticatorController();
		sc = new sessionController();
	}
	
	public void init()
	{
		System.out.println("Updating Profile.");
		authenticator = new authenticatorController();
		loadHtml = new loadObjectsToHtmlController();
		sc = new sessionController();
		Database.validateDatabase(Database.getDatabase());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
        response.setContentType("html;charset=UTF-8");
        WebUser user = sessionData.getCurrentSessionUser();
        Address address = user.getAddress();
        Card card = Database.getCard(user.getEmail());
        
        String updateProfile = request.getParameter("submitChange");
        String changePassword = request.getParameter("changePassword");
        
        //We are updating profile.
        if(updateProfile != null && updateProfile.equals("Changes"))
        {
        	Card newCard = null;
        	String cardHolderName = request.getParameter("cardname");
        	String cardNumber = request.getParameter("cardnumber");
        	String cardcvv = request.getParameter("cardcvv");
        	String cardZip = request.getParameter("cardzipcode");
        	String cardMonth = request.getParameter("Month");
        	String cardYear = request.getParameter("Year");
        	
        	Address userAddress = null;
        	String addressLine = request.getParameter("addressLine");
        	String city = request.getParameter("city");
        	String state = request.getParameter("state");
        	String addressZip = request.getParameter("billingZipCode");
        	String country = request.getParameter("country");
        	
        	String promoUpdates = request.getParameter("promoCheckBox");
    		boolean receivePromo = false;
    		if(promoUpdates != null)
    		{
    			receivePromo = true;
    		}
        	
        	
    		// Checks to see if all payment and address fields are set.
        	if(!Validator.validateAllPaymentFieldsAreSet(cardHolderName, cardNumber, cardcvv, cardZip))
        	{
        		request.setAttribute("errorMsg",ERROR_DATA.PAYMENT_METHOD_FILLED_ERROR);
        		sc.navigatePage(request, response, "/editProfile.jsp");
        		return;
        	}
        	if(!Validator.validateAllPaymentFieldsAreSet(addressLine, city, state, addressZip))
        	{
        		request.setAttribute("errorMsg",ERROR_DATA.ADDRESS_FILLED_ERROR);
        		sc.navigatePage(request, response, "/editProfile.jsp");
        		return;
        	}
        	
        	//Update card, address, and profile
        	newCard = new Card(cardHolderName, cardcvv, cardMonth + "-" + cardYear, cardNumber, cardZip);
        	Database.updateCard(newCard, user);
        	userAddress = new Address(addressLine, city, state, country, addressZip);
        	Database.updateAddress(userAddress, user);
        	Database.updateProfile(user, request.getParameter("fName"), request.getParameter("lName"), request.getParameter("phonenumber"), receivePromo);
        	
        	//Updated profile message
        	request.setAttribute("errorMsg", generateHTMLController.updatedProfile());
        	
        	//Refresh database with new values
        	Database.resetDatabase();
        	WebUser userSession = sessionData.getCurrentSessionUser();
        	user = Database.getUser(userSession.getEmail());
        	
        	//Send confirmation Email
        	EmailController _email = new EmailController();
        	_email.sendEmail(user, email.updateProfile, email.confirmProfileUpdate);
        	
        	loadHtml.setProfilePage(request, response, user);
        	return;
        }
        
        if(changePassword != null && changePassword.contentEquals("Password"))
        {
        	sc.navigatePage(request, response, "/passwordPrompt.jsp");
        	return;
        }
        
        
    }
	

}
