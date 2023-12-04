package models;

import java.io.Serializable;

public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    private String name;
    private String customerId;
    public User (String customerId, String name) {
        this.setCustomerId(customerId);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
