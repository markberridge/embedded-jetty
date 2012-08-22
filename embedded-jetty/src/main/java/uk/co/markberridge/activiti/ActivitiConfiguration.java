package uk.co.markberridge.activiti;

import java.sql.Driver;

import javax.sql.DataSource;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

/**
 * @author mberridge
 */
@Configuration
public class ActivitiConfiguration implements ApplicationContextAware {

    private @Value("${activiti.db:h2}")
    String db;

    private @Value("${activiti.jdbc.driverClassName:org.h2.Driver}")
    String driverClass;

    private @Value("${activiti.jdbc.url:jdbc:h2:tcp://localhost/activiti}")
    String url;

    private @Value("${activiti.jdbc.username:sa}")
    String username;

    private @Value("${activiti.jdbc.password:}")
    String password;

    private ApplicationContext applicationContext;

    @Bean
    public TransactionAwareDataSourceProxy actvitiDataSource() throws ClassNotFoundException {
        return new TransactionAwareDataSourceProxy(actvitiTargetDataSource());
    }

    @SuppressWarnings("unchecked")
    @Bean
    public DataSource actvitiTargetDataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClass));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager activitiTransactionManager() throws Exception {
        DataSourceTransactionManager activitiTransactionManager = new DataSourceTransactionManager();
        activitiTransactionManager.setDataSource(actvitiTargetDataSource());
        return activitiTransactionManager;
    }

    @Bean
    public SpringProcessEngineConfiguration activitiProcessEngineConfiguration() throws Exception {
        SpringProcessEngineConfiguration activitiConfig = new SpringProcessEngineConfiguration();
        activitiConfig.setDatabaseType(db);
        activitiConfig.setDataSource(actvitiDataSource());
        activitiConfig.setTransactionManager(activitiTransactionManager());
        activitiConfig.setDatabaseSchemaUpdate("true");
        activitiConfig.setDeploymentResources(new Resource[] { new ClassPathResource("activiti/hello.bpmn20.xml"),
            new ClassPathResource("activiti/twitter.bpmn20.xml") });
        activitiConfig.setJobExecutorActivate(false);
        return activitiConfig;
    }

    @Bean
    public ProcessEngine actvitiProcessEngine() throws Exception {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(activitiProcessEngineConfiguration());
        processEngineFactoryBean.setApplicationContext(this.applicationContext);
        return processEngineFactoryBean.getObject();
    }

    @Bean
    public RepositoryService activitiRepositoryService() throws Exception {
        return actvitiProcessEngine().getRepositoryService();
    }

    @Bean
    public RuntimeService activitiRuntimeService() throws Exception {
        return actvitiProcessEngine().getRuntimeService();
    }

    @Bean
    public TaskService activitiTaskService() throws Exception {
        return actvitiProcessEngine().getTaskService();
    }

    @Bean
    public HistoryService activitiHistoryService() throws Exception {
        return actvitiProcessEngine().getHistoryService();
    }

    @Bean
    public ManagementService activitiManagementService() throws Exception {
        return actvitiProcessEngine().getManagementService();
    }

    @Bean
    public FormService activitiFormService() throws Exception {
        return actvitiProcessEngine().getFormService();
    }

    @Bean
    public ProcessInitiator processInitiator() {
        return new ActivitiProcessInitiator();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
