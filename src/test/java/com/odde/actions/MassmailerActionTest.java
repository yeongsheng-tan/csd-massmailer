package com.odde.actions;


import com.odde.actions.MassmailerAction;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;

public class MassmailerActionTest extends StrutsSpringTestCase {
    @Test
    public void testMassmailerExecuteSuccess() throws Exception{
        request.getParameter("fromAddress");
        request.getParameter("toAddress");
        request.getParameter("subject");
        request.getParameter("emailBody");

        ActionProxy proxy = getActionProxy("/massmailer.action");

        MassmailerAction massMailerAction = (MassmailerAction) proxy.getAction();

        String result = proxy.execute();

        assertTrue("There were errors present in form fields.", massMailerAction.getFieldErrors().size() == 0);
        assertEquals("Result returned form executing the action was not success but it should have been.", "success", result);
    }
}
