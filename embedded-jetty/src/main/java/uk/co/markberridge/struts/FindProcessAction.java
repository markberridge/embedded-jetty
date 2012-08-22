package uk.co.markberridge.struts;

import java.util.List;

import uk.co.markberridge.model.Process;
import uk.co.markberridge.service.ProcessService;

import com.opensymphony.xwork2.ActionSupport;

public class FindProcessAction extends ActionSupport {

    private static final String LIST = "list";

    private ProcessService processService;

    private List<Process> processList;
    private String processId;

    @Override
    public String execute() throws Exception {
        processList = processService.getProcesses();
        if (processList.isEmpty()) {
            addActionError("No processes found");
            return INPUT;
        }
        if (processList.size() == 1) {
            processId = processList.get(0).getId();
            return SUCCESS;
        }
        return LIST;
    }

    public ProcessService getProcessService() {
        return processService;
    }

    public void setProcessService(ProcessService processService) {
        this.processService = processService;
    }

    public List<Process> getProcessList() {
        return processList;
    }

    public String getProcessId() {
        return processId;
    }
}
