package uk.co.markberridge.struts;

import java.util.Map;

import uk.co.markberridge.model.Task;

public class TaskAction extends BaseProcessAction {

    private String taskId;
    private Task task;

    @Override
    public String input() throws Exception {
        task = getProcessService().startTask(taskId);
        return super.input();
    }

    @Override
    public String execute() throws Exception {
        getProcessService().completeTask(getTaskId(), getProcessVariables());
        return SUCCESS;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Task getTask() {
        return task;
    }

    public Map<String, String> getTaskVariables() {
        return task.getVariables();
    }
}
