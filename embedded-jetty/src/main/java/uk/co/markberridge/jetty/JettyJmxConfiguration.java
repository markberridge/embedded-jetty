package uk.co.markberridge.jetty;

import java.util.HashMap;
import java.util.Map;

import javax.management.remote.JMXServiceURL;

import org.eclipse.jetty.jmx.ConnectorServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import uk.co.markberridge.FileSystemProperties;

@Configuration
public class JettyJmxConfiguration {

    @Value("${jetty.jmx.port:1099}")
    private Integer port;

    @Value("${jetty.jmx.host:localhost}")
    private String host;

    @Value("${jetty.jmx.security.enabled:true}")
    private Boolean secured;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public ConnectorServer jettyJmxConnextorServer() throws Exception {
        String urlPath = String.format("/jndi/rmi://%s:%s/jmxrmi", host, port);
        JMXServiceURL jmxServiceURL = new JMXServiceURL("rmi", host, port, urlPath);
        ConnectorServer connectorServer = new ConnectorServer(jmxServiceURL, getEnvironment(),
                "org.eclipse.jetty.jmx:name=rmiconnectorserver");
        return connectorServer;
    }

    private Map<String, ?> getEnvironment() {
        Map<String, String> env = new HashMap<String, String>();
        // secure JMX access - see http://wiki.eclipse.org/Jetty/Tutorial/JMX
        if (secured) {
            FileSystemProperties passwordFile = new FileSystemProperties("jmx.password.txt");
            FileSystemProperties accessFile = new FileSystemProperties("jmx.access.txt");
            env.put("jmx.remote.x.password.file", passwordFile.getFile().getAbsolutePath());
            env.put("jmx.remote.x.access.file", accessFile.getFile().getAbsolutePath());
        }
        return env;
    }

}
