package uk.co.markberridge.struts;

public class NewTweetAction extends StartProcessAction {

    @Override
    public String execute() throws Exception {
        super.execute();
        addActionMessage("Tweet submitted for review");
        return SUCCESS;
    }
}
