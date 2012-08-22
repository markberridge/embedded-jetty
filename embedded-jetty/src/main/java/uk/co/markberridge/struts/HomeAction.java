package uk.co.markberridge.struts;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

    private String message;

    @Override
    public String execute() throws Exception {
        setMessage("Struts2 is up and running ...");
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
