package services;

import java.util.Properties;
import java.util.*;
import javax.activation.*;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailServiceImpl implements EmailService,Cloneable {
	private static EmailServiceImpl emailServ;
	public static EmailServiceImpl getEmailServ()
	{
		if(emailServ==null)
		{
			emailServ=new EmailServiceImpl();
		}
		return emailServ.createClone();
	}
	
	private EmailServiceImpl createClone()
	{
		try {
			return (EmailServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void emailSend(String invoiceid) {
		String to="121003013@sastra.ac.in";
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
			MimeMessage msg=new MimeMessage(s);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject("Invoice pdf and excel");
			 BodyPart messageBodyPart1 = new MimeBodyPart();  
			    messageBodyPart1.setText("This is invoice pdf part");  
			    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
			    
			    String filename ="C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\servletproj\\\\"+invoiceid+".pdf";
				 //change accordingly  
			    DataSource source = new FileDataSource(filename);  
			    messageBodyPart2.setDataHandler(new DataHandler(source));  
			    messageBodyPart2.setFileName(filename);  
			    messageBodyPart2.setText("thank you for using this service provided by ajithraj");
			    Multipart multipart = new MimeMultipart();  
			    multipart.addBodyPart(messageBodyPart1);  
			    multipart.addBodyPart(messageBodyPart2);
			    msg.setContent(multipart);

	        Transport transport = s.getTransport("smtps");

	        transport.connect("smtp.gmail.com", "dhuvaraggnajithraj@gmail.com", "dartheinspiron");
			transport.sendMessage(msg,msg.getAllRecipients());
			
		}catch(MessagingException me) {
			me.printStackTrace();
			
		}

	}

}
