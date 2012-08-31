package uk.co.markberridge.service;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import uk.co.markberridge.test.Mock;
import uk.co.markberridge.test.MockUnitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ActivitiServiceImplTest extends MockUnitTestCase {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public ActivitiService activitiService() {
            return new ActivitiServiceImpl();
        }

        @Bean
        RepositoryService repositoryService() {
            return createMock(RepositoryService.class);
        }

        @Bean
        RuntimeService runtimeService() {
            return createMock(RuntimeService.class);
        }

        @Bean
        TaskService taskService() {
            return createMock(TaskService.class);
        }

        @Bean
        HistoryService historyService() {
            return createMock(HistoryService.class);
        }

        @Bean
        ManagementService managementService() {
            return createMock(ManagementService.class);
        }

        @Bean
        FormService formService() {
            return createMock(FormService.class);
        }
    }

    @Autowired
    private ActivitiService activitiService;

    @Autowired
    @Mock
    private RepositoryService mockRepositoryService;
    
    @Autowired
    @Mock
    private RuntimeService mockRuntimeService;
    
    @Autowired
    @Mock
    private TaskService mockTaskService;
    
    @Autowired
    @Mock
    private HistoryService mockHistoryService;
    
    @Autowired
    @Mock
    private ManagementService mockManagementService;
    
    @Autowired
    @Mock
    private FormService mockFormService;

    @Override
    // TODO collect Mocks from annotation
    protected Object[] getMocks() {
        return new Object[] { mockRepositoryService, mockRuntimeService, mockTaskService, mockHistoryService,
            mockManagementService, mockFormService };
    }

    @Test
    public void testHello() {
        EasyMock.expect(mockRuntimeService.startProcessInstanceByKey("helloProcess")).andReturn(null);
        playbackMocks();
        activitiService.hello();
    }

    @Test
    public void testTweet() {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("tweet", "TWEET");
        EasyMock.expect(mockRuntimeService.startProcessInstanceByKey("twitterProcess", variables)).andReturn(null);
        playbackMocks();
        activitiService.tweet("TWEET");
    }
}
