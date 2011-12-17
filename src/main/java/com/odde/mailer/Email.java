package com.odde.mailer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Email {

	private List<String> recipientAddresses = new ArrayList<String>();

	public List<String> getRecipientAddresses() {
		return recipientAddresses;
	}

	private String from;
	private String subject = "";
	private String message = "";

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

	public void addRecipients(String... receipentEmails) {
		recipientAddresses.addAll(Arrays.asList(receipentEmails));
	}

	public void addRecipientsFromStringThatIsSemicolonDelimited(String recipient) {
		List<String> toAddressList = Arrays.asList(recipient.split(";"));
		List<String> fixedAddressList = new ArrayList<String>();
		for (String toAddr : toAddressList) {
			if (toAddr.trim().length() > 0)
				fixedAddressList.add(toAddr.trim());
		}
		addRecipients(fixedAddressList.toArray(new String[fixedAddressList
				.size()]));
	}

	public void clearRecipients() {
		recipientAddresses.clear();
	}
}
