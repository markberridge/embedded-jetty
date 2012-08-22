package uk.co.markberridge.struts;

import java.util.List;

import uk.co.markberridge.model.Task;
import uk.co.markberridge.service.ProcessService;

import com.opensymphony.xwork2.ActionSupport;

public class FindTaskAction extends ActionSupport {

    private static final String LIST = "list";

    private ProcessService processService;

    private CurrentUser currentUser = new CurrentUser("kermit");
    private List<Task> taskList;

    @Override
    public String execute() throws Exception {
        taskList = processService.getTasks(getUsername());
        if (taskList.isEmpty()) {
            addActionError("No tasks found");
            return INPUT;
        }
        return LIST;
    }

    public ProcessService getProcessService() {
        return processService;
    }

    public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public String getUsername() {
        return currentUser.getUsername();
    }
}
