package uk.co.markberridge;

import java.io.File;

import org.springframework.core.io.FileSystemResource;

public class FileSystemProperties extends FileSystemResource {

    public FileSystemProperties(String propertiesFileName) {
        super(getFile(propertiesFileName));
    }
    
    private static File getFile(String propertiesFileName) {
        File userHomeDir = new File(System.getProperty("user.home"));
        File propsDir = new File(userHomeDir, ".markberridge");
        return new File(propsDir, propertiesFileName);
    }
}
