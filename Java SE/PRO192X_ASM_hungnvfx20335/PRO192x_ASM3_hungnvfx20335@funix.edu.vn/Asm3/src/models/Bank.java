package models;

import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {
    private String ID;
    private ArrayList<DigitalCustomer> customers;
    public Bank() {
        this.setID(String.valueOf(UUID.randomUUID()));
        this.setCustomers(new ArrayList<>());
    }
    public void addCustomer(DigitalCustomer newCustomer) {
        if (getCustomerById(newCustomer.getCustomerId()) == null) {
            getCustomers().add(newCustomer);
        }
    }
    public void displayInformationCustomer() {
        for (DigitalCustomer digitalCustomer : customers) {
            System.out.println(digitalCustomer.displayInformationAccount());
        }
    }
    public DigitalCustomer getCustomerById(String customerId ) {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            if (digitalCustomer.getCustomerId().equalsIgnoreCase(customerId)) {
                return digitalCustomer;
            }
        }
        return null;
    }

    public boolean checkAccountBalance(String balance) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(balance);
        return matcher.matches();
    }
    public boolean validateBalance(String balance) {
        if (checkAccountBalance(balance)) {
            return Double.parseDouble(balance) >= 50000.0;
        }
        return false;
    }
    public void displayInformationTransactionAccount() {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            System.out.println(digitalCustomer.displayInformationTransactionAccount());
        }
    }
    public boolean validateCustomerId(String customerId) {
        String regex = "^\\d{12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(customerId);
        return matcher.matches();
    }
    public boolean isAccountExisted(String customerID, String accountNumber) {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            if (digitalCustomer.getCustomerId().equals(customerID)) {
                return digitalCustomer.isAccountExisted(accountNumber);
            }
        }
        return false;
    }
    public boolean isCustomerExisted(DigitalCustomer newCustomer) {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            if (digitalCustomer.equals(newCustomer)) {
                return true;
            }
        }
        return false;
    }

    public boolean validateAccount(String customerID, String accountNumber) {
        if (checkAccountNumber(accountNumber)) {
            if (isAccountExisted(customerID, accountNumber)) {
                System.out.println("Tài khoản ATM đã tồn tại");
                return false;
            } else {
                return true;
            }
        } else {
            System.out.println("Nhập không đúng tài khoản");
        }
        return false;

    }
    public boolean checkAccountNumber(String accountNumber) {
        String regex = "^\\d{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(accountNumber);
        return matcher.matches();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<DigitalCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<DigitalCustomer> customers) {
        this.customers = customers;
    }
}
