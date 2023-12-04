package models;

public class User {
    private String name;
    private String customerId;
    public User (String name, String customerId) {
        this.setName(name);
        this.setCustomerId(customerId);
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
