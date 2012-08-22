package uk.co.markberridge.struts;

public class ReviewTweetAction extends TaskAction {

    @Override
    public String execute() throws Exception {
        super.execute();
        if (isApproved()) {
            addActionMessage("Tweet approved");
        } else {
            addActionMessage("Tweet approval declined");
        }
        return SUCCESS;
    }

    public boolean isApproved() {
        return Boolean.valueOf(getProcessVariables().get("approved"));
    }
}
