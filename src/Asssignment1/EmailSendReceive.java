package Asssignment1;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
public class EmailSendReceive {
	/**
	 * @param args
	 */
	public static void main(String [] args) {
		String to="krsdharman@gmail.com";
		String from="dhuvaraggnajithraj@gmail.com";
		String host="localhost";
		Properties p=System.getProperties();
		p.put("smtp.gmail.com", host);
		p.put("mail.smtp.port", "587");
		Session s = Session.getInstance(p, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication("dhuvaraggnajithraj@gmail.com", "dartheinspiron");
			}
			}); 
		try {
			for(int i=0;i<10;i++) {
			MimeMessage msg=new MimeMessage(s);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject("ajith is hacking ur account");
			msg.setText("thank you for using this service provided by ajithraj");

	        Transport transport = s.getTransport("smtps");

	        transport.connect("smtp.gmail.com", "dhuvaraggnajithraj@gmail.com", "dartheinspiron");
			transport.sendMessage(msg,msg.getAllRecipients());
			}
		}catch(MessagingException me) {
			me.printStackTrace();
			
		}
	}

}
 