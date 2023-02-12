import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class TestSendEmail {

	public static void sendEmail(String email, String otp) {
		  Properties properties = new Properties();
		  properties.put("mail.debug", "true");
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.host", "smtp.gmail.com");
		  properties.put("mail.smtp.port", "587");
		  properties.put("mail.smtp.auth", "true");
		  
	        properties.put("mail.smtp.connectiontimeout", 5000);
	        properties.put("mail.smtp.timeout", 5000);

	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	        	   protected PasswordAuthentication getPasswordAuthentication() {
	        		    return new PasswordAuthentication("grace880212@gmail.com", 
	        		    		"Xyf880212");
	        		   }
	        		  });

	        try {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("grace880212@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
	            message.setSubject("Testing Subject");
	            message.setText("Hello, this is a test email with OTP: " + otp);

	            Transport.send(message,"grace880212@gmail.com", "Xyf880212");
	            System.out.println("Email sent successfully.");
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
    
}
	public static void main(String[] args) {
		
		sendEmail("grace880212@gmail.com","123456");
	}
}
