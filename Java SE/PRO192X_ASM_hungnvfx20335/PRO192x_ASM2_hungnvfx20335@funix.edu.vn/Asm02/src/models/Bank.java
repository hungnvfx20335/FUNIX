package models;

import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    private String Id;
    private ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.setId(String.valueOf(UUID.randomUUID()));
    }
    public boolean checkAccountNumber(String number) {
        String regex = "^\\d{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public void addCustomer(Customer newCustomer) {
        if (isCustomerExisted(newCustomer.getCustomerID()) == null) {
            this.customers.add(newCustomer);
        }
    }
    public void addAccount(String customerId, Account account) {
        for (Customer customer : getCustomers()) {
            if (customer.getCustomerID().equals(customerId)) {
                customer.addAccount(account);
            }
        }
    }
    public Customer isCustomerExisted(String customerID) {
        for (Customer value : getCustomers()) {
            if (value.getCustomerID().equals(customerID)) {
                return value;
            }
        }
        return null;
    }
    public Customer isNameExisted(String name) {
        for (Customer value : getCustomers()) {
            if (value.getName().contains(name)) {
                return value;
            }
        }
        return null;
    }
    public void displayInformation() {
       for (Customer value : customers) {
           System.out.println(value.toString());
       }
    }
    public void searchCustomerID(String customerID) {
        String answer = null;
        for (int i = 0; i < getCustomers().size(); i++) {
            Customer customer = this.customers.get(i);
            if (customerID.equals(customer.getCustomerID())) {
                answer = customer.toString();
                break;
            }
        }
        assert answer != null;
        System.out.println(answer);
    }
    public void searchName(String name) {
        String answer = null;
        for (int i = 0; i < getCustomers().size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getName().contains(name)) {
                answer = customer.toString();
            }
        }
        assert answer != null;
        System.out.println(answer);
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

}
