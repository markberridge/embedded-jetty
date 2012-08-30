package uk.co.markberridge;

import java.util.logging.Level;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import uk.co.markberridge.activiti.ActivitiConfiguration;
import uk.co.markberridge.activiti.ProcessInitiator;
import uk.co.markberridge.camel.CamelConfiguration;
import uk.co.markberridge.jetty.JettyRemoteJmxConfiguration;
import uk.co.markberridge.jetty.JettyStrutsConfiguration;
import uk.co.markberridge.service.ActivitiService;
import uk.co.markberridge.service.MyService;
import uk.co.markberridge.service.ServiceConfiguration;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

@Component
public class App {

    private static Logger log = Logger.getLogger(App.class);

    @Autowired
    private MyService service;

    @Autowired
    private ActivitiService activitiService;

    @Autowired
    private ProcessInitiator processInitiator;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        log.info("STARTING APPLICATION");
        configureLogging();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        configure(context);
        context.refresh();
        double elapsedTime = ((System.currentTimeMillis() - (double) startTime) / 1000.0);
        log.info("APPLICATION STARTED IN " + elapsedTime + "s");
        context.getBean(App.class).start();
    }

    private static void configureLogging() {

        // Redirect java.util.logging --> SLF4J
        LogManager.getLogManager().reset();
        SLF4JBridgeHandler.install();
        java.util.logging.Logger.getLogger("global").setLevel(Level.FINEST);

        // Redirect System.out --> SLF4J
        SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
    }

    private static void configure(AnnotationConfigApplicationContext context) {

        context.setId("root-context");
        context.register(PropertyPlaceholderConfigurer.class);
        PropertyPlaceholderConfigurer configurer = context.getBean(PropertyPlaceholderConfigurer.class);
        configurer.setProperties(new ApplicationProperties());
        configurer.setLocations(new Resource[] { new FileSystemProperties("app.properties") });
        configurer.setIgnoreResourceNotFound(true);
        configurer.setSearchSystemEnvironment(true);

        // context.scan("uk.co.markberridge"); // a bit too much magic!
        context.register(AppConfiguration.class);
        context.register(ServiceConfiguration.class);
        context.register(JettyStrutsConfiguration.class);
        context.register(JettyRemoteJmxConfiguration.class);
        context.register(ActivitiConfiguration.class);
        context.register(CamelConfiguration.class);
    }

    private void start() {
        log.info("Service execute: " + service.getProp());
        // activitiService.hello();
        // activitiService.tweet("Integrated #Activiti with twitter. Activiti rocks!");
    }
}
