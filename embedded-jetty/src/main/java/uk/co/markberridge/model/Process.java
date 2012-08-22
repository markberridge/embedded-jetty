package uk.co.markberridge.model;

public class Process {

    private final String id;
    private final String key;
    private final String name;
    private final int version;
    private final String actionName;

    public Process(String id, String key, String name, int version, String actionName) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.version = version;
        this.actionName = actionName;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public String getActionName() {
        return actionName;
    }
}
