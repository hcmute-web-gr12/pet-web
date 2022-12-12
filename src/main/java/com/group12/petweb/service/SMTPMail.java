package com.group12.petweb.service;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SMTPMail implements Mail {
	final Session session;
	final String email;
	public SMTPMail(String email, String password) {
		final var props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		final var auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		};

		session = Session.getInstance(props, auth);
		this.email = email;
	}

	public void sendTo(String addressList, String subject, String text) throws MessagingException {
		final var message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressList));
		message.setSubject(subject);
		message.setText(text);
		Transport.send(message);
	}
}
