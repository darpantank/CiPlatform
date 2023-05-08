package com.ciplatform.service;

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
	public static boolean send(String email,String messageText,String subject) {
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
			String msg=messageText;
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject(subject);
//			message.setText(msg);
			message.setContent(msg,"text/html");
			// send message
			Transport.send(message);
			status=true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		finally {
			return status;
		}
		
	}
}
