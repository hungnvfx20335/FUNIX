package models;

import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    public String printInformationAccount() {
        return "Đây là tài khoản Account";
    }
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    public String printHistoryTransaction() {
        StringBuilder informationTransaction = new StringBuilder();
        for (Transaction transaction : transactions) {
            informationTransaction.append("GD: ").append(transaction.printTransaction());
        }
        return informationTransaction.toString();
    }
    public boolean checkAccountPremium() {
        return (balance >= 10000000.0);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
