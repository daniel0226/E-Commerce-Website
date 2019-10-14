package eCommerce.Controllers;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.UserData.Card;
import eCommerce.users.*;
import eCommerce.Validator.*;
import eCommerce.Error.ERROR_DATA;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
        private static final long serialVersionUID = 2L;
        private Card newPaymentCard;

        public RegisterController() {
                super();
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
        {
                response.setContentType("html;charset=UTF-8");

                // Replace this with database stuff
                // Required Fields
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirmPassword");
                String emailAddress = request.getParameter("email");
                String birthday = request.getParameter("bday");// Appears yyyy-mm-dd
                  
                //Card info, If field is blank, String returned is "".
                String cardHolderName = request.getParameter("cardholdername");
                String cardNumber = request.getParameter("cardnumber");
                String expMonth = request.getParameter("Month");
                String expYear = request.getParameter("Year");
                String CVV = request.getParameter("cvv");
                String zipcode = request.getParameter("zipcode");
                
                //Validations
                //JavaScript handles password and confirm password being equal
                //HTML handles email address syntax
                //HTML handles all inputs not related to payment are filled
                
                
                //Validate that email isn't already used.
                if(!Validator.validateRegistrationEmailIsUnique(emailAddress))
                {
                	request.setAttribute("errorOutput", ERROR_DATA.NOT_UNIQUE_EMAIL);
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                    return;
                }
                
                //If user inputed some data into the payment fields, but didn't fill out all fields
                //Ignore month and year since they are preset in HTML.
                if(!Validator.validateAllPaymentFieldsAreSet(cardHolderName, cardNumber, CVV, zipcode))
                {
                	request.setAttribute("paymentErrorOutput", ERROR_DATA.PAYMENT_METHOD_FILLED_ERROR);
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                    return;
                }
                
                
                //What are other possible registration checks?
                //*Password Strength
                //*Check if card is legit <- Maybe through API?
               
                
                //Add user to database.
                newPaymentCard = new Card(cardHolderName, CVV, expMonth + "-" + expYear, cardNumber, zipcode);
                WebUser newUser = new WebUser(firstName, lastName, password, confirmPassword, emailAddress, birthday,
                                newPaymentCard);
                newUser.setConfirmed(false);
                //Database insert _ etc etc
                
                //Redirect to register Thank you
                response.sendRedirect("registerThankyou.html");
                
        }
}