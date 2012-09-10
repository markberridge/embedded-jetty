package uk.co.markberridge.jmx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MBeanConfiguration {

    @Bean
    public ApplicationCache applicationCache() {
        // TODO create a delegate to wrap the business service and act as MBean
        return new ApplicationCache(10, "a", "b", "c", "d");
    }

    @Bean
    public ApplicationCacheService applicationCacheService() {
        // give application access to different interface of MBean purely for demonstration
        return (ApplicationCacheService) applicationCache();
    }
}
