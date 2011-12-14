package com.odde.mailer;

import org.junit.Test;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class MailSendReceiptTest {
    @Test
    public void testSentEmailIsReceived() throws AddressException, MessagingException {
        SmtpHost smtpHost = new SmtpHost("localhost",2500);
        
        Wiser wiser = new Wiser();
        wiser.setHostname(smtpHost.getSmtpHostname());
        wiser.setPort(smtpHost.getSmtpPortNum());
        wiser.start();

        Mailer mailClient = new Mailer(smtpHost);
        Email email = new Email();
        List<String> toAddrList = new ArrayList<String>();
        toAddrList.add("abc@localhost.com");
        email.setTo(toAddrList);
        email.setFrom("from@dummy");
        email.setSubject("Test email");
        email.setMessage("THIS IS A TEST EMAIL");
        mailClient.send(email);

        List<WiserMessage> receivedMessages = wiser.getMessages();
        System.out.println(receivedMessages.get(0));
        assertEquals(1, receivedMessages.size());
        wiser.stop();
    }
}
