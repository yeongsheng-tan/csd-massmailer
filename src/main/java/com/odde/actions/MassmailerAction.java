package com.odde.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

@Conversion()
public class MassmailerAction extends ActionSupport {

	private static final long serialVersionUID = -9088844058039000823L;
    private String fromAddress;
    private String toAddress;
    private String subject;

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

    private String emailBody;

	public String execute() throws Exception {
//        SmtpHost smtpHost = new SmtpHost("localhost",2500);
//        Mailer mailer = new Mailer(smtpHost);
//
//        Email email = new Email();
//        email.setFrom(massMailer.getFromAddress());
//
//        String[] emailAddressesArray = StringUtils.split(massMailer.getToAddress(),";");
//        List<String> toAddresses = new ArrayList<String>();
//        for(int a=0;a<emailAddressesArray.length;a++){
//            if(emailAddressesArray[a].trim().length()>0){
//                toAddresses.add(emailAddressesArray[a].trim());
//            }
//        }
//        email.setTo(toAddresses);
//        email.setSubject(massMailer.getEmailBody());
//
//        mailer.send(email);
        System.out.println(fromAddress);
        return SUCCESS;
    }
}
