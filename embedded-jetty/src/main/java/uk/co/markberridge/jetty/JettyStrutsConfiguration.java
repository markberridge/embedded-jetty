package uk.co.markberridge.jetty;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.EnumSet;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServer;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.eclipse.jetty.jmx.MBeanContainer;
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
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import uk.co.markberridge.jmx.ApplicationCache;
import uk.co.markberridge.jmx.ApplicationCacheMBean;
import uk.co.markberridge.jmx.ApplicationCacheService;
import uk.co.markberridge.spring.ContextAwareContextLoaderListener;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@Configuration
public class JettyStrutsConfiguration {

    private static final String STRUTS2 = "struts2";
    private static final String SITEMESH = "sitemesh";

    @Value("${jetty.port:8080}")
    private Integer port;

    @Value("${jetty.host:localhost}")
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
        server.getContainer().addEventListener(mbeanContainer());
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
        servletHandler.addFilter(sitemeshFilterHolder(), sitemeshFilterMapping());
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
    public FilterHolder sitemeshFilterHolder() {
        FilterHolder filterHolder = new FilterHolder(SiteMeshFilter.class);
        filterHolder.setName(SITEMESH);
        return filterHolder;
    }

    @Bean
    public FilterMapping sitemeshFilterMapping() {
        FilterMapping filterMapping = new FilterMapping();
        filterMapping.setPathSpec("/*");
        filterMapping.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
        filterMapping.setFilterName(SITEMESH);
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

    // ######
    // ### JMX & MBeans
    // ######

    @Bean(initMethod = "start", destroyMethod = "stop")
    public MBeanContainer mbeanContainer() throws Exception {
        MBeanContainer mBeanContainer = new MBeanContainer(mBeanServer());
        return mBeanContainer;
    }

    @Bean
    public MBeanServer mBeanServer() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        return mBeanServer;
    }

    @Bean
    public MBeanExporter mBeanExporter() {
        MBeanExporter mBeanExporter = new MBeanExporter();
        mBeanExporter.setServer(mBeanServer());
        Map<String, Object> mbeans = new HashMap<String, Object>();
        mbeans.put("app:bean=Cache", applicationCacheMBean());
        mBeanExporter.setBeans(mbeans);
        return mBeanExporter;
    }

    @Bean
    public ApplicationCacheMBean applicationCacheMBean() {
        return new ApplicationCache(10, "a", "b", "c", "d");
    }

    @Bean
    public ApplicationCacheService applicationCacheService() {
        return (ApplicationCacheService) applicationCacheMBean();
    }
}
