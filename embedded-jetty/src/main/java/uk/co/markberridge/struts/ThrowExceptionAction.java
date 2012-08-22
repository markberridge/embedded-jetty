package uk.co.markberridge.struts;

import com.opensymphony.xwork2.ActionSupport;

public class ThrowExceptionAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        throw new RuntimeException("A test exception...");
    }
}
