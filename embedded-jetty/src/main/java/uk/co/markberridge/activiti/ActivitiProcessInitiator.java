package uk.co.markberridge.activiti;

import org.activiti.spring.annotations.ProcessVariable;
import org.activiti.spring.annotations.StartProcess;

/**
 * TODO The interceptor is not picking up the @StartProcess annotations
 */
public class ActivitiProcessInitiator implements ProcessInitiator {

    @StartProcess(processKey = "helloProcess", returnProcessInstanceId = true)
    public String startHelloProcess() {
        return null;
    }

    @StartProcess(processKey = "twitterProcess", returnProcessInstanceId = true)
    public String startTwitterProcess(@ProcessVariable("tweet") String tweet) {
        return null;
    }
}
