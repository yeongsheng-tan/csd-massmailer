package com.odde.mailer;

import java.util.Properties;

public class SmtpHost {
    private String smtpHostname;
    private int smtpPortNum=25;

    public SmtpHost(String smtpHostname, int smtpPortNum) {
		this.smtpHostname=smtpHostname;
        this.smtpPortNum=(smtpPortNum==0 ? 25:smtpPortNum);
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
