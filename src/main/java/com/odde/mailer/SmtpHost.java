package com.odde.mailer;

import java.util.Properties;

public class SmtpHost {
    private String smtpHostname;
    private int smtpPortNum=25;

    public SmtpHost(String smtpHostname){
        this.smtpHostname=smtpHostname;
    }
    
    public SmtpHost(String smtpHostname, int smtpPortNum) {
		this.smtpHostname=smtpHostname;
        this.smtpPortNum=smtpPortNum;
	}

    public String getSmtpHostname() {
        return smtpHostname;
    }

    public int getSmtpPortNum() {
        return smtpPortNum;
    }

    public Properties asProperty() {
        Properties smtpHostProps = new Properties();
        smtpHostProps.setProperty("mail.smtp.host",smtpHostname);
        smtpHostProps.setProperty("mail.smtp.port",String.valueOf(smtpPortNum));
        return smtpHostProps;

    }
}
