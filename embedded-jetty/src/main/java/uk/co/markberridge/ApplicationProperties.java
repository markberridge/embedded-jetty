package uk.co.markberridge;

import java.util.Properties;

public class ApplicationProperties extends Properties {

    public ApplicationProperties() {
        setProperty("env.property", "PropertyPlaceholderConfigurer");
    }
}
