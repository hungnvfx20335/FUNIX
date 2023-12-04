package models;

import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Account> accounts;
    public Customer(String name, String customerID) {
        super(name, customerID);
        this.setAccounts(new ArrayList<>());
    }
    public String isPremiumAccount() {
        String answer = "Normal  ";
        for (Account account : getAccounts()) {
            if (account.isPremium()) {
                answer = "Premium ";
            }
        }
        return answer;
    }
    public double getBalance() {
        double answer = 0.0;
        for (Account account : getAccounts()) {
            answer += account.getBalance();
        }
        return answer;
    }
    public void addAccount(Account newAccount) {
        if (findAccount(newAccount.getAccountNumber()) == null) {
            this.accounts.add(newAccount);
        } else {
            System.out.println("Số tài khoản đã tồn tại");
        }
    }
    public Account findAccount(String accountNumber) {
        for (Account account : getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    public String toString() {
        StringBuilder customerInformation = new StringBuilder(String.format("%-15s%-20s%-10s%-15f%-3s%n", getCustomerID() + " | ", getName(),
                " | " + isPremiumAccount() + " | ", getBalance(),"VND"));
        if(getAccounts().size() == 0) {customerInformation.append("No account");}
        else {
            for (int i = 0; i < getAccounts().size(); i++) {
                Account account = this.accounts.get(i);
                customerInformation.append((i + 1)).append(account.toString());
            }
        }
        return customerInformation.toString();
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


}
