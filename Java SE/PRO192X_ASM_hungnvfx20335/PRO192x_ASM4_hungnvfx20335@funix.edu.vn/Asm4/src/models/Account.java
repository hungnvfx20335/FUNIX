package models;

import dao.TransactionDao;
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Account implements Serializable {
    public static final long serialVersionUID = 1L;
    private String accountNumber;
    private String customerId;
    private double balance;
    public Account(String customerId,String accountNumber, double balance) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public boolean isPremium() {
        return getBalance() >= 10000000.0;
    }

    public void createTransaction(Transaction transaction) throws IOException {
        ArrayList<Transaction> transactions = TransactionDao.listTransaction();
        transactions.add(transaction);
        TransactionDao.save(transactions);
    }
    public String displayTransaction() {
        StringBuilder transactionAmount = new StringBuilder("\n");
        TransactionDao.listTransaction().forEach(transaction -> {
            if (this.accountNumber.equals(transaction.getAccountNumber())) {
                transactionAmount.append(transaction);
            }
        });
        return transactionAmount.toString();
    }

    public String showInformationAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balance = currencyVN.format(getBalance());
        return String.format("%-5s%-10s%-20s%-15s%-25s%n", "",getAccountNumber() + " |", "", "|                 ", balance);
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
