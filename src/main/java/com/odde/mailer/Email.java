package com.odde.mailer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Email {

	private List<String> recipientAddresses = new ArrayList<String>();
	private String from;
	private String subject="";
	private String message="";
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addRecipients(String ... receipentEmails) {
		recipientAddresses.addAll(Arrays.asList(receipentEmails));
	}
	public List<String> getRecipients() {	
		return recipientAddresses;
	}

}
