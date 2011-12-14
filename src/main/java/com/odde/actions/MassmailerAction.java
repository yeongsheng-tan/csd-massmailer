package com.odde.actions;

import com.odde.formbeans.MassMailer;
import com.odde.mailer.Email;
import com.odde.mailer.Mailer;
import com.odde.mailer.SmtpHost;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Conversion()
public class MassmailerAction extends ActionSupport {

	private static final long serialVersionUID = -9088844058039000823L;
    private MassMailer massMailer;
    
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

        return SUCCESS;
    }

    public MassMailer getMassMailer() {
        return massMailer;
    }

    public void setMassMailer(MassMailer massMailer) {
        this.massMailer = massMailer;
    }
}
