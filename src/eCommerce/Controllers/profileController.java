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
import eCommerce.Strings.generateHTMLController;
import eCommerce.UserData.Address;
import eCommerce.UserData.Card;
import eCommerce.UserData.sessionData;
import eCommerce.Validator.Validator;
import eCommerce.users.WebUser;

@WebServlet("/profileController")
public class profileController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//This class only gets called if
	//sessionController validates that the user is logged in.
	public profileController()
	{
		super();
	}
	
	public void init()
	{
		System.out.println("Updating Profile.");
		if(Database.getDatabase() == null)
		{
			try {
				new Database();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
        	
        	
        	if(!Validator.validateAllPaymentFieldsAreSet(cardHolderName, cardNumber, cardcvv, cardZip))
        	{
        		request.setAttribute("errorMsg",ERROR_DATA.PAYMENT_METHOD_FILLED_ERROR);
        		request.getRequestDispatcher("./editProfile.jsp").forward(request, response);
        		return;
        	}
        	if(!Validator.validateAllPaymentFieldsAreSet(addressLine, city, state, addressZip))
        	{
        		request.setAttribute("errorMsg",ERROR_DATA.ADDRESS_FILLED_ERROR);
        		request.getRequestDispatcher("./editProfile.jsp").forward(request, response);
        		return;
        	}
        	
        	//Update card
        	newCard = new Card(cardHolderName, cardcvv, cardMonth + "-" + cardYear, cardNumber, cardZip);
        	Database.updateCard(newCard, user);
        	//Update Address
        	userAddress = new Address(addressLine, city, state, country, addressZip);
        	Database.updateAddress(userAddress, user);
        	//Update Profile
        	Database.updateProfile(user, request.getParameter("fName"), request.getParameter("lName"), request.getParameter("phonenumber"));
        	
        	//NEED TO ADD UPDATE PROMOTION
        	
        	request.setAttribute("errorMsg", generateHTMLController.updatedProfile());
        	Database.resetDatabase();
        	
        	user = sessionData.getCurrentSessionUser();
        	address = user.getAddress();
        	card = Database.getCard(user.getEmail());
        	//User
			request.setAttribute("fName", user.getFirstName());
			request.setAttribute("lName", user.getLastName());
			request.setAttribute("phonenumber", user.getPhoneNumber());
			request.setAttribute("bDay", user.getBirthday());
			
			//Payment
			authenticatorController authenticator = new authenticatorController();
			request.setAttribute("cardname", card.getCardName());
			request.setAttribute("CVV", authenticator.decryptString(card.getCVV()));
			request.setAttribute("cardNumber", authenticator.decryptString(card.getCardNumber()));
			request.setAttribute("month", card.getCardMonth());
			request.setAttribute("year", card.getCardYear());
			request.setAttribute("cardZipCode", card.getZipCode());
			
			//Address
			request.setAttribute("addressLine", address.getAddressLine());
			request.setAttribute("city", address.getCity());
			request.setAttribute("state", address.getState());
			request.setAttribute("country", address.getCountry());
			request.setAttribute("billingZipCode", address.getZipCode());
        	request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
        	return;
        }
        
        if(changePassword != null && changePassword.contentEquals("Password"))
        {
        	request.getRequestDispatcher("./passwordPrompt.jsp").forward(request, response);
        	return;
        }
        
        
    }
	

}
