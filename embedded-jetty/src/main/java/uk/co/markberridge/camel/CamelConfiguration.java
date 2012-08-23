package uk.co.markberridge.camel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfiguration {

    @Value("${jetty.jmx.port:1099}")
    private Integer port;

}
