package uk.co.markberridge.service;

import java.util.List;
import java.util.Map;

import uk.co.markberridge.model.Process;
import uk.co.markberridge.model.Task;

public interface ProcessService {

    public List<Process> getProcesses();

    public List<Task> getTasks(String username);

    public void startProcessByKey(String key, Map<String, String> variables);

    public Task startTask(String id);

    public void completeTask(String id, Map<String, String> variables);
}
