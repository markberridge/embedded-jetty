package uk.co.markberridge.model;

import java.util.Map;

public class Task {

    private final String id;
    private final String name;
    private final String decription;
    private final String actionName;
    private final Map<String, String> variables;

    public Task(String id, String name, String description, String actionName, Map<String, String> variables) {
        this.id = id;
        this.name = name;
        this.decription = description;
        this.actionName = actionName;
        this.variables = variables;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDecription() {
        return decription;
    }

    public String getActionName() {
        return actionName;
    }

    public Map<String, String> getVariables() {
        return variables;
    }
}
