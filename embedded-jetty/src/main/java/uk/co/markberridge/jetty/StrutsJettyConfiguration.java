package uk.co.markberridge.jetty;

import java.io.IOException;
import java.util.EventListener;

import javax.servlet.ServletException;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import uk.co.markberridge.spring.ContextAwareContextLoaderListener;

@Configuration
public class StrutsJettyConfiguration {

    private static final String STRUTS2 = "struts2";

    @Value("${jetty.port:8080}")
    private Integer port;

    @Value("${jetty.host:127.0.0.1}")
    private String host;

    @Value("${jetty.context:/}")
    private String context;

    // TODO change default to false
    @Value("${struts.devMode:true}")
    private Boolean strutsDevMode;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server jettyServer() throws Exception {
        Server server = new Server();
        server.setConnectors(new Connector[] { httpConnector() });
        server.setHandler(webAppContext());
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
    public ContextHandler webAppContext() throws IOException, ServletException {
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(context);
        ClassPathResource classPathResource = new ClassPathResource("webapp");
        String webapp = classPathResource.getURI().toString();
        webAppContext.setResourceBase(webapp);
        webAppContext.setServletHandler(strutsServletHandler());
        webAppContext.setErrorHandler(errorHandler());
        webAppContext.setWelcomeFiles(new String[] { "index.jsp" });
        
        // create a ServletContextListerner which will create the WebApplicationContext
        webAppContext.addEventListener(springContextListener());
        webAppContext.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        return webAppContext;
    }

    @Bean
    public ServletHandler strutsServletHandler() {
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addFilter(strutsFilterHolder(), strutsFilterMapping());
        return servletHandler;
    }

    @Bean
    public FilterHolder strutsFilterHolder() {
        FilterHolder filterHolder = new FilterHolder(StrutsPrepareAndExecuteFilter.class);
        filterHolder.setName(STRUTS2);
        filterHolder.setInitParameter("struts.devMode", strutsDevMode.toString());
        return filterHolder;
    }

    @Bean
    public FilterMapping strutsFilterMapping() {
        FilterMapping filterMapping = new FilterMapping();
        filterMapping.setPathSpec("*.action");
        filterMapping.setFilterName(STRUTS2);
        return filterMapping;
    }

    @Bean
    public ErrorHandler errorHandler() {
        ErrorPageErrorHandler errorHandler = new ErrorPageErrorHandler();
        errorHandler.addErrorPage(404, "/404.html");
        errorHandler.addErrorPage(500, "/500.jsp");
        return errorHandler;
    }

    @Bean
    public EventListener springContextListener() {
        return new ContextAwareContextLoaderListener();
    }
}
