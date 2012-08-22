package uk.co.markberridge.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    private final String prop;

    public MyServiceImpl() {
        this("MyServiceImpl");
    }

    public MyServiceImpl(String prop) {
        this.prop = prop;
    }

    @Override
    public String getProp() {
        return prop;
    }

    @Override
    public String getMesssage() {
        return "The service is successfully integrated with Struts2...";
    }
}
