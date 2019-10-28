package eCommerce.Controllers;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import eCommerce.users.WebUser;

import java.util.Properties;

public class EmailController 
{
	final private String username = "bookamovie1@gmail.com";
    final private String password = "Movie@gmail123";
    Properties prop = null;

	public EmailController()
	{
		prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
	}
	
	public void sendEmail(WebUser user, String subject, String emailMsg)
	{
		String key = user.getCode(); // Registration code.
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
            message.setText(emailMsg + " " + "Here is your code" + key);

            Transport.send(message, message.getAllRecipients());

            System.out.println("Sent email successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}
