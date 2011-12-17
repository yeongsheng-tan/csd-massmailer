package com.odde.mailer;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	private Email email;

	@Before
	public void createEmail() {
		email = new Email();
	}
	
	@Test
	public void parseOneRecipentAddressWithoutSemiColon() throws Exception {
		email.addRecipientsFromStringThatIsSemicolonDelimited("abc@apple.com");

		assertEquals(1, email.getRecipientAddresses().size());
		assertEquals("abc@apple.com", email.getRecipientAddresses().get(0));
	}
	
	@Test
    public void parseSingleRecipientAddressWithSemiColon() throws Exception{
		email.addRecipientsFromStringThatIsSemicolonDelimited("abc@odd.com;");
		assertEquals(1, email.getRecipientAddresses().size());
		assertEquals("abc@odd.com", email.getRecipientAddresses().get(0));
	}
	
	@Test
	public void parseMultipleRecipientAddressesWithSemiColon() throws Exception{
		email.addRecipientsFromStringThatIsSemicolonDelimited("abc@oddes.com;bcd@a.com");

		assertEquals(2, email.getRecipientAddresses().size());
		
		assertEquals("abc@oddes.com", email.getRecipientAddresses().get(0));
		assertEquals("bcd@a.com", email.getRecipientAddresses().get(1));
	}
	
	@Test
	public void parseMultipleRecipientAddressesWithSemiColonAtTheEnd() throws Exception{
		email.addRecipientsFromStringThatIsSemicolonDelimited("abc@oddes.com;bcd@a.com;");

		assertEquals(2, email.getRecipientAddresses().size());
		
		assertEquals("abc@oddes.com", email.getRecipientAddresses().get(0));
		assertEquals("bcd@a.com", email.getRecipientAddresses().get(1));
	}

	@Test
	public void parseMultipleRecipientAddressesWithMultipleSemiColonAtTheEnd() throws Exception{
		email.addRecipientsFromStringThatIsSemicolonDelimited("abc@oddes.com;bcd@a.com;;;;;;");

		assertEquals(2, email.getRecipientAddresses().size());
		
		assertEquals("abc@oddes.com", email.getRecipientAddresses().get(0));
		assertEquals("bcd@a.com", email.getRecipientAddresses().get(1));
	}
	
}
