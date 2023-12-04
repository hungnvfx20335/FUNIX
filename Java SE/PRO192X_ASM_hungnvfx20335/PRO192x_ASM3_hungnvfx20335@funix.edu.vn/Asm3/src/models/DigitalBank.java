package models;

public class DigitalBank extends Bank{

    public DigitalBank () {
        super();
    }
    public void addASavingsAccount(String customerID, SavingsAccount newAccount) {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            if (digitalCustomer.getCustomerId().equalsIgnoreCase(customerID)) {
                digitalCustomer.addSavingsAccount(newAccount);
            }
        }
    }
    public void addCreditAccount(String customerID, CreditAccount newAccount) {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            if (digitalCustomer.getCustomerId().equalsIgnoreCase(customerID)) {
                digitalCustomer.addCreditAccount(newAccount);
            }
        }
    }
    public void withdrawMoneyAccount(String customerID, Account account) {
        for (DigitalCustomer digitalCustomer : getCustomers()) {
            if (digitalCustomer.getCustomerId().equals(customerID)) {
                digitalCustomer.withdrawMoneyAccount(account);
            }
        }
    }
}
