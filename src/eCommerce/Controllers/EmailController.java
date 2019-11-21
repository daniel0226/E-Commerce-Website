package eCommerce.Controllers;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eCommerce.Database.Database;
import eCommerce.users.WebUser;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import eCommerce.Strings.email;


@WebServlet("/EmailController")
public class EmailController extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final private String username = "bookamovie1@gmail.com";
    final private String password = "Movie@gmail123";
    private sessionController session_c;
    Properties prop = null;

    //If class is called by jsp
    public void init()
    {
    	session_c = new sessionController();
    	prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
    }
    
    //If class is created 
	public EmailController()
	{
		prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String emailToSendConfirmation = request.getParameter("email");
		WebUser user = Database.getUser(emailToSendConfirmation);
		String reconfirm = email.reconfirmMsg + " http://localhost:8080/cinemaBooking/registerConfirmation.jsp?email=" + user.getEmail()+"&code="+user.getCode();
		System.out.println(reconfirm);
		sendEmail(user, email.confirmMsg, reconfirm);
		request.setAttribute("loginError", email.confirmationSent);
		session_c.navigatePage(request, response, "/login.jsp");
    }
	
	public void sendEmail(WebUser user, String subject, String emailMsg)
	{
		Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bookamovie1@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));

            message.setSubject(subject);
            message.setText(emailMsg);

            Transport.send(message, message.getAllRecipients());

            System.out.println("Sent email successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	public void updateUsers(String subject, String message)
	{
		List<WebUser> list = Database.getAllUsers();
		if(list == null || list.size() == 0)
		{
			return;
		}
		for(int i = 0; i<list.size(); i++)
		{
			WebUser currentUser = list.get(i);
			if(currentUser.isReceivingPromoUpdates())
			{
				sendEmail(currentUser,subject, message);
			}else {
				continue;
			}
		}
	}
}
