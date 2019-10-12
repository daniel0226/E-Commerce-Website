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
import eCommerce.Controllers.Validation;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
        private static final long serialVersionUID = 2L;
        private Card newPaymentCard;

        public RegisterController() {
                super();
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
                response.setContentType("text/html;charset=UTF-8");

                // Replace this with database stuff
                // Required Fields
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String password = request.getParameter("password");
                String confirmPassword = request.getParameter("confirmPassword");
                String emailAddress = request.getParameter("email");
                String birthday = request.getParameter("bday");// Appears yyyy-mm-dd
                
                //Card info If field is blank, String returned is "".
                String cardHolderName = request.getParameter("cardholdername");
                String cardNumber = request.getParameter("cardnumber");
                String expMonth = request.getParameter("Month");
                String expYear = request.getParameter("Year");
                String CVV = request.getParameter("cvv");
                String zipcode = request.getParameter("zipcode");
                
                     
                // Create User
                WebUser newUser = new WebUser(firstName, lastName, password, confirmPassword, emailAddress, birthday,
                                newPaymentCard);
                
        }
}
