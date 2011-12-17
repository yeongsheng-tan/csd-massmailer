package com.odde.actions;

import java.util.List;

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
		 	request.setParameter("fromAddress", "abs@xyz.com");
	        request.setParameter("toAddress", "ravikiran.kakarla@gmail.com;");
	        request.setParameter("subject", "Hello World!!!");
	        request.setParameter("emailBody", "gdshfsdhfskdhfksdhfksfhksdfhk");
	    }
	    
	    @Test
	    public void testSendEmailExecuteSuccess() throws Exception{

	        ActionProxy proxy = getActionProxy("/sendEmail.action");

	        String result = proxy.execute();
	        
	        assertEquals("Result returned form executing the action was not success but it should have been.", "success", result);
	    }
	 	
	    
	    @Test
	    public void testSendEmailActionExecuteWithEmptyToAddressRoutesToError() throws Exception{
		 	request.setParameter("fromAddress", "abs@xyz.com");
	        request.setParameter("toAddress", " ");
	        request.setParameter("subject", "Hello World!!!");
	        request.setParameter("emailBody", "gdshfsdhfskdhfksdhfksfhksdfhk");
	    	
	        ActionProxy proxy = getActionProxy("/sendEmail.action");

	        String result = proxy.execute();
	        
	        assertEquals("Result returned form executing the action should return ERROR.", "error", result);
	    }
	    
	    
	    @Test
	    public void testSendEmailExecuteFailureForSubject() throws Exception{

	        request.setParameter("subject", "");
	    	
	    	ActionProxy proxy = getActionProxy("/sendEmail.action");
	        
	        SendEmailAction sendEmailAction = (SendEmailAction) proxy.getAction();
	        String result = proxy.execute();

	        List<String> subjectErrors = sendEmailAction.getFieldErrors().get("subject");
	        assertTrue("The email subject failed validations", subjectErrors != null && subjectErrors.size() == 1);
	        assertEquals("Result returned form executing the action was not input but it should have been.", "input", result);
	    }
	    
	    @Test
	    public void testSendEmailExecuteFailureForToAddress() throws Exception{

	        request.setParameter("toAddress", "");
	    	
	    	ActionProxy proxy = getActionProxy("/sendEmail.action");
	        
	        SendEmailAction sendEmailAction = (SendEmailAction) proxy.getAction();
	        String result = proxy.execute();

	        List<String> toAddressErrors = sendEmailAction.getFieldErrors().get("toAddress");
	        assertTrue("The email To Address failed validations", toAddressErrors != null && toAddressErrors.size() == 1);
	        assertEquals("Result returned form executing the action was not input but it should have been.", "input", result);
	    }

	    @Test
	    public void testSendEmailExecuteFailureForEmailBody() throws Exception{

	        request.setParameter("emailBody", "");
	    	
	    	ActionProxy proxy = getActionProxy("/sendEmail.action");
	        
	        SendEmailAction sendEmailAction = (SendEmailAction) proxy.getAction();
	        String result = proxy.execute();

	        List<String> emailBodyErrors = sendEmailAction.getFieldErrors().get("emailBody");
	        assertTrue("The email Email Body failed validations", emailBodyErrors != null && emailBodyErrors.size() == 1);
	        assertEquals("Result returned form executing the action was not input but it should have been.", "input", result);
	    }	    

	    
	    @Test
	    public void testSendMailErrorIsSetToTheExceptionThatWasThrown() throws Exception{
	        request.setParameter("toAddress", " ");
	    	
	    	ActionProxy proxy = getActionProxy("/sendEmail.action");
	        
	        SendEmailAction sendEmailAction = (SendEmailAction) proxy.getAction();
	        String result = proxy.execute();

	        assertEquals("error", result);
	        assertTrue(sendEmailAction.getSendMailError().contains("No recipients defined"));
	    }	    
	    
	    
	    public void tearDown()  throws Exception {
	    	super.tearDown();
	    	wiser.stop();
	    }
	  
}
