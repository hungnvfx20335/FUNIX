package models;

import java.text.NumberFormat;
import java.util.Locale;

public class Transaction {
    private String id;
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;
    public Transaction (String id, String accountNumber, double amount, String time, boolean status) {
        this.setId(id);
        this.setAccountNumber(accountNumber);
        this.setAmount(amount);
        this.setTime(time);
        this.setStatus(status);
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
    @Override
    public String toString() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String amount = currencyVN.format(getAmount());
        return String.format("%-15s%-20s%-30s%-40s%5s%n",  "GD:   " + getAccountNumber(),"| " + amount + " |",
                getTime(),"| " + getId() + " |", isStatus());
    }
}
