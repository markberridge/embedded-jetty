package uk.co.markberridge.service;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ActivitiServiceImpl implements ActivitiService {

    private static Logger log = Logger.getLogger(ActivitiServiceImpl.class);

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
    public void hello() {
        log.info("hello() called");
        runtimeService.startProcessInstanceByKey("helloProcess");
    }

    @Override
    @Transactional
    public void tweet(String tweet) {
        log.info("tweet(\"" + tweet + "\") called");
        runtimeService.startProcessInstanceByKey("twitterProcess");
    }
}
