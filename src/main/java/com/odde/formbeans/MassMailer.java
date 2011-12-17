package com.odde.formbeans;

public class MassMailer {
    private String fromAddress;
    private String toAddress;
    private String emailBody;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = (emailBody==null ? "BLANK EMAIL BODY":emailBody);
    }
}
