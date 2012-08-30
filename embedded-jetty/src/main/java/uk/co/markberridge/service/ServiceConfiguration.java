package uk.co.markberridge.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    private @Value("${env.property:ServiceConfiguration}")
    String prop;

    @Bean
    public MyService myService() {
        return new MyServiceImpl(prop);
    }

    @Bean
    public ActivitiService activitiService() {
        return new ActivitiServiceImpl();
    }

    @Bean
    public PrinterService printer() {
        return new PrinterServiceImpl();
    }

    @Bean
    public ProcessService processService() {
        return new ProcessServiceImpl();
    }
}
