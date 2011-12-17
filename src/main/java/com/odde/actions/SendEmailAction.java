package com.odde.actions;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;
import com.odde.mailer.Email;
import com.odde.mailer.Mailer;
import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport {

	private static final long serialVersionUID = 2074934414284943579L;
	
	private String toAddress;
	private String fromAddress;
	private String subject;
	private String emailBody;
	private Mailer mailer;
	private String sendMailError = "";

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getToAddress() {
		return this.toAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getFromAddress() {
		return this.fromAddress;
	}

	public String execute() {
		Email email = new Email();
		email.setFrom(fromAddress);
		email.addRecipientsFromStringThatIsSemicolonDelimited(toAddress);
		email.setMessage(emailBody);
		email.setSubject(subject);

		try {
			getMailer().send(email);
			return SUCCESS;

		} catch (Exception e) {
			setSendMailError(e.getMessage());
			return ERROR;
		}
	}

	public void setMailer(Mailer mailer) {
		this.mailer = mailer;
	}
	
	private Mailer getMailer() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Mailer mailer = (Mailer) context.getBean("myMailer");
		return mailer;
	}
	
	
	public void validate() {
		if (getSubject()== null || getSubject().length() == 0)
			addFieldError("subject", "Email subject is required");
		if (getToAddress() == null || getToAddress().length() == 0)
			addFieldError("toAddress", "Email To Address is required");
		if (getEmailBody() == null || getEmailBody().length() == 0)
			addFieldError("emailBody", "Email Body is required");
	}

	public String getSendMailError() {
		return sendMailError;
	}

	public void setSendMailError(String sendMailError) {
		this.sendMailError = sendMailError;
	}

}
