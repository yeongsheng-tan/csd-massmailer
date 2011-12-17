package com.odde.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;

@Conversion()
public class MassmailerAction extends ActionSupport {
    
	private static final long serialVersionUID = 1677777647488888161L;

	public String execute() throws Exception {
        return SUCCESS;
    }
}
