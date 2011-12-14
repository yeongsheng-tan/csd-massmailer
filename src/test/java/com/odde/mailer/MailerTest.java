package com.odde.mailer;

import static org.junit.Assert.assertEquals;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MailerTest {

	private Message sentMessage;
	private Mailer myMailer;
	private Email email = createDummyEmail();
	

	@Before
	public void createMyNewMailer() {
		myMailer = new Mailer(new SmtpHost("localhost",0)) {
			
			protected void send(Message msg) {
				sentMessage = msg;
				
			}
		};		
		
	}

	@Test
	public void testSendEmailToAddress() throws AddressException, MessagingException {
		
		List<String> recipientEmailAddresses=new ArrayList<String>();
        recipientEmailAddresses.add("toEmail@To.com");
		email.setTo(recipientEmailAddresses);
		myMailer.send(email);
        assertEquals(1,sentMessage.getAllRecipients().length);
        assertEquals(new InternetAddress(recipientEmailAddresses.get(0)), sentMessage.getAllRecipients()[0]);
	}
	
	@Test
	public void testSendEmailFromAddress() throws AddressException, MessagingException {
		
		String fromEmail="fromEmail@To.com";
		email.setFrom(fromEmail);
		myMailer.send(email);
		assertEquals(new InternetAddress(fromEmail), sentMessage.getFrom()[0]);
	}

	@Test
	public void testSendEmailSubject() throws AddressException, MessagingException {
		String recipientSubject = "Hello World!";
		email.setSubject(recipientSubject);
		myMailer.send(email);
		assertEquals(recipientSubject, sentMessage.getSubject());
	}
	
	private Email createDummyEmail(){
		
		Email email=new Email();
		email.setFrom("from@dummy");
        List<String> toAddrList = new ArrayList<String>();
        toAddrList.add("To@dummy.com");
		email.setTo(toAddrList);
		email.setSubject("dummySubject");
		email.setMessage("dummyMessage");
		
		return email;
	}


}
