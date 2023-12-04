package models;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<Transaction> transactions;
    public Account(String accountNumber, double balance) {
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setTransactions(new ArrayList<>());
    }
    public boolean isPremium() {
        return getBalance() >= 10000000.0;
    }

    public void addTransaction(Transaction transactionAmount) {
        this.transactions.add(transactionAmount);
    }
    public String displayTransaction() {
        StringBuilder transactionAmount = new StringBuilder("\n");
        for (int i = 0; i < getTransactions().size(); i++) {
            Transaction transaction = this.getTransactions().get(i);
            transactionAmount.append(transaction.toString());
        }
        return transactionAmount.toString();
    }

    public String displayAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balance = currencyVN.format(getBalance());
        return String.format("%-5s%-10s%-20s%-15s%-25s%n", "",getAccountNumber() + " |", "",
                "|                 ", balance);
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

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
