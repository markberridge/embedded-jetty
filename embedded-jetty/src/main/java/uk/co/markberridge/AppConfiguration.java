package uk.co.markberridge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.markberridge.service.ActivitiService;
import uk.co.markberridge.service.ActivitiServiceImpl;
import uk.co.markberridge.service.MyService;
import uk.co.markberridge.service.MyServiceImpl;
import uk.co.markberridge.service.PrinterService;
import uk.co.markberridge.service.PrinterServiceImpl;
import uk.co.markberridge.service.ProcessService;
import uk.co.markberridge.service.ProcessServiceImpl;

@Configuration
public class AppConfiguration {

    private @Value("${env.property:AppConfiguration}")
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

    @Bean
    public App app() {
        return new App();
    }
}
