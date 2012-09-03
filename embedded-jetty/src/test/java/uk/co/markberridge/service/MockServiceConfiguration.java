package uk.co.markberridge.service;

import static uk.co.markberridge.test.EasyMockTestCase.createMock;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockServiceConfiguration {

    @Bean
    public ActivitiService activitiService() {
        return createMock(ActivitiServiceImpl.class);
    }

    @Bean
    public RepositoryService repositoryService() {
        return createMock(RepositoryService.class);
    }

    @Bean
    public RuntimeService runtimeService() {
        return createMock(RuntimeService.class);
    }

    @Bean
    public TaskService taskService() {
        return createMock(TaskService.class);
    }

    @Bean
    public HistoryService historyService() {
        return createMock(HistoryService.class);
    }

    @Bean
    public ManagementService managementService() {
        return createMock(ManagementService.class);
    }

    @Bean
    public FormService formService() {
        return createMock(FormService.class);
    }
}
