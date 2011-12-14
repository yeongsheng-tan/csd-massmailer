package com.odde.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUploadAction extends ActionSupport{
    private File emailFile;
    private String emailFileContentType;
    private String emailFileName;
    private String emailTextFromFile="";

    public String execute(){
        return SUCCESS;
    }

    public File getEmailFile() {
        return emailFile;
    }

    public void setEmailFile(File emailFile) {
        this.emailFile = emailFile;
    }

    public String getEmailFileContentType() {
        return emailFileContentType;
    }

    public void setEmailFileContentType(String emailFileContentType) {
        this.emailFileContentType = emailFileContentType;
    }

    public String getEmailFileName() {
        return emailFileName;
    }

    public void setEmailFileName(String emailFileName) {
        this.emailFileName = emailFileName;
    }

    public String getEmailTextFromFile() throws IOException {
        if(emailFile!=null)
            emailTextFromFile=FileUtils.readFileToString(emailFile);
        return emailTextFromFile;
    }

    public void setEmailTextFromFile(String emailTextFromFile) {
        this.emailTextFromFile = emailTextFromFile;
    }
}
