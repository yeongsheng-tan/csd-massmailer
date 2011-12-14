package com.odde.mailer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
	private Session session;

	public Mailer(SmtpHost smtpHost) {
        session = Session.getInstance(smtpHost.asProperty());
	}

	public void send(Email email) throws AddressException, MessagingException {
		Message message = new MimeMessage(session);
				
		for(String toAddr : email.getTo()){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddr));
        }
        message.setFrom(new InternetAddress(email.getFrom()));
		message.setSubject(email.getSubject());
        message.setText(email.getMessage());
		send(message);
	}

	

	protected void send(Message msg) throws MessagingException {
        Transport.send(msg);
	}
}
