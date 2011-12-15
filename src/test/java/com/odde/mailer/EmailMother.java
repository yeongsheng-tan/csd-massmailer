package com.odde.mailer;

public class EmailMother {
    public static Email createDummyEmailWithOneValidRecipients() {
        Email email = new Email();
        email.addRecipients("a_valid_dummy_to_email_addr@yourmail.com");
        email.setFrom("a_valid_dummy_from_email_addr@mymail.com");
        return email;
    }

    public static Email createDummyEmailWithInValidRecipients() {
        Email email = new Email();
        email.addRecipients("invalid_dummy_to_email_addr#yourmail.com");
        email.setFrom("a_valid_dummy_from_email_addr@mymail.com");
        return email;
    }
}
