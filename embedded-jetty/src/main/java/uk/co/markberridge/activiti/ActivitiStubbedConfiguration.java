package uk.co.markberridge.activiti;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricDetailQuery;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.management.TableMetaData;
import org.activiti.engine.management.TablePageQuery;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.JobQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Attachment;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mberridge
 */
@Configuration
public class ActivitiStubbedConfiguration {

    @Bean
    public RepositoryService activitiRepositoryService() throws Exception {
        return new RepositoryService() {

            @Override
            public InputStream getResourceAsStream(String deploymentId, String resourceName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<String> getDeploymentResourceNames(String deploymentId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public void deleteDeploymentCascade(String deploymentId) {
                // Auto-generated method stub

            }

            @Override
            public void deleteDeployment(String deploymentId, boolean cascade) {
                // Auto-generated method stub

            }

            @Override
            public void deleteDeployment(String deploymentId) {
                // Auto-generated method stub

            }

            @Override
            public ProcessDefinitionQuery createProcessDefinitionQuery() {
                return new StuubedProcessDefinitionQuery();
            }

            @Override
            public DeploymentQuery createDeploymentQuery() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public DeploymentBuilder createDeployment() {
                // Auto-generated method stub
                return null;
            }
        };
    }

    @Bean
    public RuntimeService activitiRuntimeService() throws Exception {
        return new RuntimeService() {

            @Override
            public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey,
                                                             Map<String, Object> variables) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceByKey(String processDefinitionKey) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey,
                                                            Map<String, Object> variables) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceById(String processDefinitionId, Map<String, Object> variables) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance startProcessInstanceById(String processDefinitionId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public void signal(String executionId) {
                // Auto-generated method stub

            }

            @Override
            public void setVariablesLocal(String executionId, Map<String, ? extends Object> variables) {
                // Auto-generated method stub

            }

            @Override
            public void setVariables(String executionId, Map<String, ? extends Object> variables) {
                // Auto-generated method stub

            }

            @Override
            public void setVariableLocal(String executionId, String variableName, Object value) {
                // Auto-generated method stub

            }

            @Override
            public void setVariable(String executionId, String variableName, Object value) {
                // Auto-generated method stub

            }

            @Override
            public Map<String, Object> getVariablesLocal(String executionId, Collection<String> variableNames) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariablesLocal(String executionId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariables(String executionId, Collection<String> variableNames) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariables(String executionId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getVariableLocal(String executionId, String variableName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getVariable(String executionId, String variableName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<String> getActiveActivityIds(String executionId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public void deleteProcessInstance(String processInstanceId, String deleteReason) {
                // Auto-generated method stub

            }

            @Override
            public ProcessInstanceQuery createProcessInstanceQuery() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ExecutionQuery createExecutionQuery() {
                // Auto-generated method stub
                return null;
            }
        };
    }

    @Bean
    public TaskService activitiTaskService() throws Exception {
        return new TaskService() {

            @Override
            public void setVariablesLocal(String taskId, Map<String, ? extends Object> variables) {
                // Auto-generated method stub

            }

            @Override
            public void setVariables(String taskId, Map<String, ? extends Object> variables) {
                // Auto-generated method stub

            }

            @Override
            public void setVariableLocal(String taskId, String variableName, Object value) {
                // Auto-generated method stub

            }

            @Override
            public void setVariable(String taskId, String variableName, Object value) {
                // Auto-generated method stub

            }

            @Override
            public void setPriority(String taskId, int priority) {
                // Auto-generated method stub

            }

            @Override
            public void setOwner(String taskId, String userId) {
                // Auto-generated method stub

            }

            @Override
            public void setAssignee(String taskId, String userId) {
                // Auto-generated method stub

            }

            @Override
            public void saveTask(Task task) {
                // Auto-generated method stub

            }

            @Override
            public void saveAttachment(Attachment attachment) {
                // Auto-generated method stub

            }

            @Override
            public void resolveTask(String taskId) {
                // Auto-generated method stub

            }

            @Override
            public Task newTask(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Task newTask() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariablesLocal(String taskId, Collection<String> variableNames) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariablesLocal(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariables(String taskId, Collection<String> variableNames) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Object> getVariables(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getVariableLocal(String taskId, String variableName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getVariable(String taskId, String variableName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<Event> getTaskEvents(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<Comment> getTaskComments(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<Attachment> getTaskAttachments(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<Task> getSubTasks(String parentTaskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<Comment> getProcessInstanceComments(String processInstanceId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<Attachment> getProcessInstanceAttachments(String processInstanceId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public List<IdentityLink> getIdentityLinksForTask(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public InputStream getAttachmentContent(String attachmentId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Attachment getAttachment(String attachmentId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public void deleteUserIdentityLink(String taskId, String userId, String identityLinkType) {
                // Auto-generated method stub

            }

            @Override
            public void deleteTasks(Collection<String> taskIds, boolean cascade) {
                // Auto-generated method stub

            }

            @Override
            public void deleteTasks(Collection<String> taskIds) {
                // Auto-generated method stub

            }

            @Override
            public void deleteTask(String taskId, boolean cascade) {
                // Auto-generated method stub

            }

            @Override
            public void deleteTask(String taskId) {
                // Auto-generated method stub

            }

            @Override
            public void deleteGroupIdentityLink(String taskId, String groupId, String identityLinkType) {
                // Auto-generated method stub

            }

            @Override
            public void deleteCandidateUser(String taskId, String userId) {
                // Auto-generated method stub

            }

            @Override
            public void deleteCandidateGroup(String taskId, String groupId) {
                // Auto-generated method stub

            }

            @Override
            public void deleteAttachment(String attachmentId) {
                // Auto-generated method stub

            }

            @Override
            public void delegateTask(String taskId, String userId) {
                // Auto-generated method stub

            }

            @Override
            public TaskQuery createTaskQuery() {
                return new StubbedTaskQuery();
            }

            @Override
            public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId,
                                               String attachmentName, String attachmentDescription, String url) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId,
                                               String attachmentName, String attachmentDescription, InputStream content) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public void complete(String taskId, Map<String, Object> variables) {
                // Auto-generated method stub

            }

            @Override
            public void complete(String taskId) {
                // Auto-generated method stub

            }

            @Override
            public void claim(String taskId, String userId) {
                // Auto-generated method stub

            }

            @Override
            public void addUserIdentityLink(String taskId, String userId, String identityLinkType) {
                // Auto-generated method stub

            }

            @Override
            public void addGroupIdentityLink(String taskId, String groupId, String identityLinkType) {
                // Auto-generated method stub

            }

            @Override
            public void addComment(String taskId, String processInstanceId, String message) {
                // Auto-generated method stub

            }

            @Override
            public void addCandidateUser(String taskId, String userId) {
                // Auto-generated method stub

            }

            @Override
            public void addCandidateGroup(String taskId, String groupId) {
                // Auto-generated method stub

            }
        };
    }

    @Bean
    public HistoryService activitiHistoryService() throws Exception {
        return new HistoryService() {

            @Override
            public void deleteHistoricTaskInstance(String taskId) {
                // Auto-generated method stub

            }

            @Override
            public void deleteHistoricProcessInstance(String processInstanceId) {
                // Auto-generated method stub

            }

            @Override
            public HistoricTaskInstanceQuery createHistoricTaskInstanceQuery() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public HistoricProcessInstanceQuery createHistoricProcessInstanceQuery() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public HistoricDetailQuery createHistoricDetailQuery() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public HistoricActivityInstanceQuery createHistoricActivityInstanceQuery() {
                // Auto-generated method stub
                return null;
            }
        };
    }

    @Bean
    public ManagementService activitiManagementService() throws Exception {
        return new ManagementService() {

            @Override
            public void setJobRetries(String jobId, int retries) {
                // Auto-generated method stub

            }

            @Override
            public TableMetaData getTableMetaData(String tableName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, Long> getTableCount() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Map<String, String> getProperties() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public String getJobExceptionStacktrace(String jobId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public void executeJob(String jobId) {
                // Auto-generated method stub

            }

            @Override
            public String databaseSchemaUpgrade(Connection connection, String catalog, String schema) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public TablePageQuery createTablePageQuery() {
                // Auto-generated method stub
                return null;
            }

            @Override
            public JobQuery createJobQuery() {
                // Auto-generated method stub
                return null;
            }
        };
    }

    @Bean
    public FormService activitiFormService() throws Exception {
        return new FormService() {

            @Override
            public void submitTaskFormData(String taskId, Map<String, String> properties) {
                // Auto-generated method stub

            }

            @Override
            public ProcessInstance submitStartFormData(String processDefinitionId, String businessKey,
                                                       Map<String, String> properties) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public ProcessInstance submitStartFormData(String processDefinitionId, Map<String, String> properties) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public TaskFormData getTaskFormData(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public StartFormData getStartFormData(String processDefinitionId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getRenderedTaskForm(String taskId, String formEngineName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getRenderedTaskForm(String taskId) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getRenderedStartForm(String processDefinitionId, String formEngineName) {
                // Auto-generated method stub
                return null;
            }

            @Override
            public Object getRenderedStartForm(String processDefinitionId) {
                // Auto-generated method stub
                return null;
            }
        };
    }
}
