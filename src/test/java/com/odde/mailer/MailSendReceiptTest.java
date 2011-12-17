package com.odde.mailer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MailSendReceiptTest {
    Wiser wiser;
    SmtpHost smtpHost = new SmtpHost("localhost",2500);
    Email email; 
    
    @Before
    public void setUpMockSmtpServer(){
        wiser = new Wiser();
        wiser.setHostname(smtpHost.getSmtpHostname());
        wiser.setPort(smtpHost.getSmtpPortNum());
        wiser.start();
    }
    
    @Test
    public void testSentEmailWithOneValidRecipientIsReceived() throws AddressException, MessagingException {
        email = EmailMother.createDummyEmailWithOneValidRecipients();

        Mailer mailClient = new Mailer(smtpHost);
        mailClient.send(email);

        List<WiserMessage> receivedMessages = wiser.getMessages();
        assertEquals(1, receivedMessages.size());
    }

    @Test(expected = javax.mail.internet.AddressException.class)
    public void testSentEmailWithInValidRecipientIsNotReceived() throws AddressException, MessagingException {
        email = EmailMother.createDummyEmailWithInValidRecipients();

        Mailer mailClient = new Mailer(smtpHost);

        mailClient.send(email);
    }
    
    @Test(expected = javax.mail.internet.AddressException.class)
    public void testSentEmailWithBlankRecipientIsNotReceived() throws AddressException, MessagingException {
        email = EmailMother.createDummyEmailWithBlankRecipients();

        Mailer mailClient = new Mailer(smtpHost);

        mailClient.send(email);
    }
    
    @Test(expected = javax.mail.internet.AddressException.class)
    public void testSentEmailWithNULLRecipientIsNotReceived() throws AddressException, MessagingException {
        email = EmailMother.createDummyEmailWithNullRecipient();

        Mailer mailClient = new Mailer(smtpHost);

        mailClient.send(email);
    }

    @After
    public void terminateMockSmtpServer(){
        wiser.stop();
    }
}
