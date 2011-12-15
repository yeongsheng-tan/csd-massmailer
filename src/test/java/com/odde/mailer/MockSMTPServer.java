package com.odde.mailer;

import javax.mail.MessagingException;

import org.subethamail.wiser.Wiser;

public class MockSMTPServer {
    Wiser wiser;
   
    Email email; 	
	
	public void StartSmtpServer(String hostName,int portNumber){
		
		SmtpHost smtpHost = new SmtpHost(hostName,portNumber);
        wiser = new Wiser();
        wiser.setHostname(smtpHost.getSmtpHostname());
        wiser.setPort(smtpHost.getSmtpPortNum());
        wiser.start();
	}

	public void dump() throws MessagingException
	{
		wiser.dumpMessages(System.out);
	}
	public void stopSmtpServer(){
		wiser.stop();
	}
	
	public int countOfReceivedMessages(){
		return wiser.getMessages().size();
	}
}
