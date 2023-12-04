package models;

import java.util.Scanner;


public class Account {
    private String accountNumber;
    private double balance;
    public Account(String accountNumber, double balance) {
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }
    public boolean isPremium() {
        return getBalance() >= 10000000;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String toString() {
        return String.format("%-5s%-10s%-33s%-15f%-3s%n", " ",getAccountNumber() + " | ", " ",getBalance(), "VND");
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance <= 50000.0) {
            updateBalance();
        } else {
            this.balance = balance;
        }
    }

    public void updateBalance() {
        Scanner input = new Scanner(System.in);
        System.out.println("Số dư phải lớn hơn 50000 VNĐ");
        while (true) {
            double checkedBalance = input.nextDouble();
            if (checkedBalance >= 50000.0) {
                this.balance = checkedBalance;
                return;
            } else {
                System.out.println("Số dư phải lớn hơn 50000 VNĐ");
            }
        }
    }
}
