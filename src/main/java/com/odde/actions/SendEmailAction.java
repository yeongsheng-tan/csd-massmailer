package com.odde.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;

import com.odde.mailer.Email;
import com.odde.mailer.Mailer;
import com.odde.mailer.SmtpHost;
import com.opensymphony.xwork2.ActionSupport;

public class SendEmailAction extends ActionSupport {

	private static final long serialVersionUID = 2074934414284943579L;
	private String toAddress;
	private String fromAddress;
	private String subject;
	private String emailBody;

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
		try {
			Email email = new Email();
			email.setFrom(fromAddress);

			email.addRecipients(parseEmailAddressesFromRequest());
			email.setSubject(emailBody);

			sendEmail(email);
			return SUCCESS;

		} catch (Exception e) {
			return "failure";
		}
	}

	private String[] parseEmailAddressesFromRequest() {
		List<String> toAddressList = Arrays.asList(StringUtils.split(toAddress, ";"));
		List<String> fixedAddressList = new ArrayList<String>();
		for(String toAddr : toAddressList){
			if(toAddr.trim().length()>0)
				fixedAddressList.add(toAddr.trim());
		}

		String[] emailAddressesArray = new String[fixedAddressList.size()];
		return fixedAddressList.toArray(emailAddressesArray);
	}

	private void sendEmail(Email email) throws Exception {
		SmtpHost smtpHost = new SmtpHost("localhost", 2500);
		//SmtpHost smtpHost = new SmtpHost("mail.singnet.com.sg");
		Mailer mailer = new Mailer(smtpHost);

		mailer.send(email);
	}

}
