package models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Transaction implements Serializable {
    public static final long serialVersionUID = 1L;
    private String id;
    private String accountNumber;
    private String transactionType;
    private double amount;
    private String time;
    private boolean status;

    public Transaction(String id, String accountNumber, String transactionType, double amount, String time, boolean status) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.time = time;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String amountFormat = currencyVN.format(amount);
        return String.format("%-15s%-15s%-20s%-30s%-40s%5s%n",  "GD:   " + getAccountNumber(), "|" + getTransactionType(),"| " + amountFormat + " |",
                getTime(),"| " + getId() + " |", isStatus());
    }
}
