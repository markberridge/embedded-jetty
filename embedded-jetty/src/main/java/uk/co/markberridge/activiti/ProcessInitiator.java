package uk.co.markberridge.activiti;

public interface ProcessInitiator {

    public String startHelloProcess();

    public String startTwitterProcess(String tweet);
}
