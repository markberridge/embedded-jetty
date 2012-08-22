package uk.co.markberridge.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldJettyConfiguration {

    @Value("${jetty.port:8080}")
    private Integer port;

    @Value("${jetty.host:127.0.0.1}")
    private String host;

    @Value("${jetty.context:/hello}")
    private String context;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server jettyServer() throws Exception {
        Server server = new Server();
        server.setConnectors(new Connector[] { httpConnector() });
        server.setHandler(helloContext());
        server.setStopAtShutdown(true);
        server.setGracefulShutdown(1000);
        return server;
    }

    @Bean
    public SelectChannelConnector httpConnector() {
        SelectChannelConnector selectChannelConnector = new SelectChannelConnector();
        selectChannelConnector.setHost(host);
        selectChannelConnector.setPort(port);
        return selectChannelConnector;
    }

    @Bean
    public ContextHandler helloContext() {
        ContextHandler helloContext = new ContextHandler();
        helloContext.setContextPath(context);
        helloContext.setHandler(helloWorldHandler());
        return helloContext;
    }

    @Bean
    public HelloWorldHandler helloWorldHandler() {
        return new HelloWorldHandler();
    }
}
