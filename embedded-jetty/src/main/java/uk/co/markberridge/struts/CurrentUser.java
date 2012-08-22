package uk.co.markberridge.struts;

public class CurrentUser {

    private final String username;

    public CurrentUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
