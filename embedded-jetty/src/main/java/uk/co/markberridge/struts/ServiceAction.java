package uk.co.markberridge.struts;

import uk.co.markberridge.service.MyService;

import com.opensymphony.xwork2.ActionSupport;

public class ServiceAction extends ActionSupport {

    private MyService myService;

    private String message;
    private String prop;

    @Override
    public String execute() throws Exception {
        setMessage(myService.getMesssage());
        setProp(myService.getProp());
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public MyService getMyService() {
        return myService;
    }

    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}
