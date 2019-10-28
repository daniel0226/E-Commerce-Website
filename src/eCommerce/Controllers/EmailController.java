	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	import java.util.Properties;

	public class EmailController{

	    public static void main(String[] args) {

	        final String username = "bookamovie1@gmail.com";
	        final String password = "Movie@gmail123";

	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true");

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
	                    InternetAddress.parse("kranthi7910@gmail.com"));

	            message.setSubject("Testing Javamail via Gmail TLS");
	            message.setText("Dear Registered User,"
	                    + "\n\n This is your activation link. It expires in 24 hours!");

	            Transport.send(message, message.getAllRecipients());

	            System.out.println("Sent email successfully!");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
