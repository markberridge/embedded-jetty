package uk.co.markberridge.jmx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MBeanConfiguration {

    @Bean
    public ApplicationCacheManagement applicationCacheManagement() {
        return new ApplicationCacheManagement();
    }
}
