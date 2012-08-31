package uk.co.markberridge.service;

import java.util.Map;

import org.activiti.engine.RuntimeService;
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

import com.google.common.collect.Maps;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ActivitiServiceImplTest extends MockUnitTestCase {

    @Configuration
    static class ContextConfiguration extends MockServiceConfiguration {

        @Bean
        public ActivitiService activitiService() {
            return new ActivitiServiceImpl();
        }
    }

    @Autowired
    private ActivitiService activitiService;

    @Autowired
    @Mock
    private RuntimeService runtimeService;

    @Test
    public void testHello() {
        EasyMock.expect(runtimeService.startProcessInstanceByKey("helloProcess")).andReturn(null);
        playbackMocks();
        activitiService.hello();
    }

    @Test
    public void testTweet() {
        Map<String, Object> variables = Maps.newHashMap();
        variables.put("tweet", "TWEET");
        EasyMock.expect(runtimeService.startProcessInstanceByKey("twitterProcess", variables)).andReturn(null);
        playbackMocks();
        activitiService.tweet("TWEET");
    }
}
