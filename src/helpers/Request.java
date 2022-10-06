package helpers;

import java.io.Serializable;

public class Request implements Serializable {
    User user;
    String type;

    Request() {
        user = null;
        type = null;
    }

    public Request(String type) {
        this();
        this.type = type;
    }

    public Request(String type, User user) {
        this(type);
        this.user = user;
    }

    void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }
}
