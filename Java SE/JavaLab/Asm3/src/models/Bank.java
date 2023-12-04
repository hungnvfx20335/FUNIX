package models;

import java.util.ArrayList;

public class Bank {
    private String bankId;
    private String bankName;

    private ArrayList<Customer> customers;

    public Bank(String bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer newCustomer) {
        this.customers.add(newCustomer);
    }
    public Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
    public boolean validateAccount(String customerId, String accountNumber) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer.validateAccount(accountNumber);
            }
        }
        return false;
    }
    public void addAccount(String customerId, Account account) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.addAccount(account);
                break;
            }
        }
    }
    public void withdrawMoney(String customerId,String accountNumber, double amount) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.withdrawMoney(accountNumber, amount);
                break;
            }
        }
    }
    public void printHistoryTransaction(String customerId) {
        Customer customer = getCustomerById(customerId);
        customer.printInformationTransaction();
    }

    private String getBankId() {
        return bankId;
    }

    private void setBankId(String bankId) {
        this.bankId = bankId;
    }

    private String getBankName() {
        return bankName;
    }

    private void setBankName(String bankName) {
        this.bankName = bankName;
    }
    private void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    private ArrayList<Customer> getCustomers() {
        return customers;
    }
}
