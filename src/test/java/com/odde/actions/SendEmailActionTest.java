package com.odde.actions;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;
import org.subethamail.wiser.Wiser;

import com.odde.mailer.Email;
import com.odde.mailer.SmtpHost;
import com.opensymphony.xwork2.ActionProxy;



public class SendEmailActionTest extends StrutsSpringTestCase{
	
	    Wiser wiser;
	    SmtpHost smtpHost = new SmtpHost("localhost",2500);
	    Email email; 
	    
	    public void setUp() throws Exception {
	        wiser = new Wiser();
	        wiser.setHostname(smtpHost.getSmtpHostname());
	        wiser.setPort(smtpHost.getSmtpPortNum());
	        wiser.start();
	        super.setUp();
	    }
	    
	    @Test
	    public void testSendEmailExecuteSuccess() throws Exception{
		 	request.setParameter("fromAddress", "abs@xyz.com");
	        request.setParameter("toAddress", "ravikiran.kakarla@gmail.com;");
	        request.setParameter("subject", "Hello World!!!");
	        request.setParameter("emailBody", "gdshfsdhfskdhfksdhfksfhksdfhk");
	    	
	        ActionProxy proxy = getActionProxy("/sendEmail.action");

	        String result = proxy.execute();
	        
	        assertEquals("Result returned form executing the action was not success but it should have been.", "success", result);
	    }
	 	 
	    public void tearDown()  throws Exception {
	    	super.tearDown();
	    	wiser.stop();
	    }
	  
}
