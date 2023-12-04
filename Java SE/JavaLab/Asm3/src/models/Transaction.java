package models;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class Transaction {
    private String id = String.valueOf(UUID.randomUUID());
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;

    public Transaction(String accountNumber, double amount, String time,boolean status) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.time = time;
        this.status = status;
    }

    public String printTransaction() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String amountOfMoney = numberFormat.format(amount);
        return String.format("%11s%30s%25s%25s%5s%n", accountNumber + " |", amountOfMoney + " |", time + " |", id + " |", status);
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

    public double getAmount() {
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
}
