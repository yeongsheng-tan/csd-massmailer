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
import  com.odde.mailer.Mailer;

public class MailerTest {

	private List<Message> sentMessages = new ArrayList<Message>();
	private Mailer myMailer;
	private Email validButDummyEmail = createDummyButValidEmail();
	
	@Before
	public void createMyNewMailer() {
		myMailer = new Mailer(new SmtpHost("localhost",0)) {
			protected void send(Message msg) {
				sentMessages.add(msg);
			}
		};		
	}

	@Test
	public void sendSingleRecipient() throws AddressException, MessagingException {		
		myMailer.send(validButDummyEmail);
        assertEquals(1,sentMessages.size());
        assertEquals(new InternetAddress("To@dummy.com"), sentMessages.get(0).getAllRecipients()[0]);
	}

	@Test
	public void sendMultipleRecipients() throws AddressException, MessagingException {
		String [] recipients ={"1@email.com","2@email.com","3@email.com"};
		validButDummyEmail = createDummyEmailWithoutRecipient();
		validButDummyEmail.addRecipients(recipients);
		myMailer.send(validButDummyEmail);
        assertEquals(recipients.length,sentMessages.size());
        for(int i=0; i<recipients.length; i++)
        {
            assertEquals(new InternetAddress(recipients[i]), sentMessages.get(i).getAllRecipients()[0]);
        }
        	
	}

	@Test
	public void testSendEmailFromAddress() throws AddressException, MessagingException {
		
		String fromEmail="fromEmail@To.com";
		validButDummyEmail.setFrom(fromEmail);
		myMailer.send(validButDummyEmail);
		assertEquals(new InternetAddress(fromEmail), sentMessages.get(0).getFrom().clone()[0]);
	}

	@Test
	public void testSendEmailSubject() throws AddressException, MessagingException {
		String recipientSubject = "Hello World!";
		validButDummyEmail.setSubject(recipientSubject);
		myMailer.send(validButDummyEmail);
		assertEquals(recipientSubject, sentMessages.get(0).getSubject());
	}
	
	private Email createDummyButValidEmail(){
		Email email = createDummyEmailWithoutRecipient();
		String recipient = "To@dummy.com";
		email.addRecipients(recipient);
		
		return email;
	}

	private Email createDummyEmailWithoutRecipient() {
		Email email=new Email();
		email.setFrom("from@dummy");
		email.setSubject("dummySubject");
		email.setMessage("dummyMessage");
		return email;
	}


}
