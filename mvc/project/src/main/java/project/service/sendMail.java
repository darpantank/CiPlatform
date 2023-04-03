package project.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static boolean send(String email,String Token) {
		boolean status=false;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Authenticator ath = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("darpantatvasoft@gmail.com", "obqqezsmbocfvphm");
			}
		};
		Session session = Session.getDefaultInstance(props, ath);
		// compose message
		try {
			String msg="<!DOCTYPE html><h3>Click Below Button to Reset Your Password</h3> <br><a href=http://localhost:8080/project/validatetoken/"+Token+" class='btn btn-success'>Click Here</a>";
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("CiPlatform - Password Reset Link");
//			message.setText(msg);
			message.setContent(msg,"text/html");
			// send message
			Transport.send(message);
			status=true;
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		finally {
			return status;
		}
		
	}
}
