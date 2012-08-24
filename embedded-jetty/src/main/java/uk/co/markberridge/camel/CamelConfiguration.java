package uk.co.markberridge.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration extends SingleRouteCamelConfiguration {

    @Override
    public RouteBuilder route() {
        return new RouteBuilder() {
            public void configure() {
                from("file:data/inbox?noop=true").to("file:target/outbox");
                from("file:target/outbox?noop=true").to("bean:reader");
            }
        };
    }

    @Bean
    public Reader reader() {
        return new Reader();
    }
}
