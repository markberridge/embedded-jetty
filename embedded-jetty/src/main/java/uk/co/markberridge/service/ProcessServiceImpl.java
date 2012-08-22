package uk.co.markberridge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.cdi.ActivitiCdiException;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import uk.co.markberridge.model.Process;
import uk.co.markberridge.model.Task;

public class ProcessServiceImpl implements ProcessService {

    // private static Logger log = Logger.getLogger(ProcessServiceImpl.class);

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ManagementService managementService;

    @Autowired
    private FormService formService;

    @Override
    @Transactional
    public List<Process> getProcesses() {
        List<ProcessDefinition> processList = repositoryService.createProcessDefinitionQuery().latestVersion().list();
        List<Process> processes = new ArrayList<Process>(processList.size());
        for (ProcessDefinition processDefinition : processList) {
            String id = processDefinition.getId();
            String key = processDefinition.getKey();
            String name = processDefinition.getName();
            int version = processDefinition.getVersion();
            String action = formService.getStartFormData(id).getFormKey();
            processes.add(new Process(id, key, name, version, action));
        }
        return processes;
    }

    @Override
    @Transactional
    public List<Task> getTasks(String username) {
        List<org.activiti.engine.task.Task> taskList = taskService.createTaskQuery().taskAssignee(username).list();
        List<Task> tasks = new ArrayList<Task>(taskList.size());
        for (org.activiti.engine.task.Task task : taskList) {
            String id = task.getId();
            String name = task.getName();
            String description = task.getDescription();
            String action = formService.getTaskFormData(id).getFormKey();
            tasks.add(new Task(id, name, description, action, null));
        }
        return tasks;
    }

    @Override
    @Transactional
    public void startProcessByKey(String key, Map<String, String> variables) {
        runtimeService.startProcessInstanceByKey(key, new HashMap<String, Object>(variables));
    }

    @Override
    @Transactional
    public Task startTask(String id) {
        org.activiti.engine.task.Task activitiTask = taskService.createTaskQuery().taskId(id).singleResult();
        if (activitiTask == null) {
            throw new ActivitiCdiException("Cannot resume task with id '" + id + "', no such task.");
        }
        Map<String, Object> variables = taskService.getVariables(id);
        Task task = new Task(id, activitiTask.getName(), activitiTask.getDescription(), null, mapOfStrings(variables));
        return task;
    }

    @Override
    @Transactional
    public void completeTask(String id, Map<String, String> variables) {
        taskService.complete(id, new HashMap<String, Object>(variables));
    }

    private Map<String, String> mapOfStrings(Map<String, Object> objectMap) {
        Map<String, String> stringMap = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : objectMap.entrySet()) {
            stringMap.put(entry.getKey(), entry.getValue().toString());
        }
        return stringMap;
    }
}
