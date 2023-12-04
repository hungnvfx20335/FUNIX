package models;

import interfaces.ReportService;
import interfaces.Withdraw;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CreditAccount extends Account implements ReportService, Withdraw {
    public static double MAX_WITHDRAW = 100000000.0;
    public static double WITHDRAW_FEE = 0.05;
    public static double WITHDRAW_PREMIUM_FEE = 0.01;

    public CreditAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    public String printInformationAccount() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String balance = numberFormat.format(getBalance());
        return String.format("%13s%20s%10s%20s%n", getAccountNumber() + " |", "CREDIT |", "        |", balance);
    }

    @Override
    public void reportWithdrawMoney(double amount) {
        String regex = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(regex);
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(dateTimeFormatter);
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String amountOfMoney = numberFormat.format(amount);
        String balance = numberFormat.format(getBalance() - amount - getFee(amount));
        String moneyFee = numberFormat.format(getFee(amount));
        System.out.println("+----------+-------------------------+----------+");
        System.out.printf("%40s%n", "BIEN LAI GIAO DICH CREDIT");
        System.out.printf("Ngay G/D: %39s%n", time);
        System.out.printf("ATM ID: %41s%n", "DIGITAL BANK ATM 2023");
        System.out.printf("SO TK: %42s%n", getAccountNumber());
        System.out.printf("SO TIEN: %40s%n", amountOfMoney);
        System.out.printf("SO DU: %42s%n", balance);
        System.out.printf("PHI + VAT: %38s%n", moneyFee);
        System.out.println("+----------+-------------------------+----------+");
    }
    public double getFee(double amount) {
        double moneyFee = 0.0;
        if (checkAccountPremium()) {
            moneyFee = amount * WITHDRAW_PREMIUM_FEE;
        } else {
            moneyFee = amount * WITHDRAW_FEE;
        }
        return moneyFee;
    }

    @Override
    public double withdraw(double amount) {
        String regex = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(regex);
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(dateTimeFormatter);
        if (isAccepted(amount)) {
            reportWithdrawMoney(amount);
            System.out.println("Rút tiền thành công");
            addTransaction(new Transaction(getAccountNumber(), amount, time, true));
            return getBalance() - amount - getFee(amount);
        }
        System.out.println("Rút tiền thất bại");
        addTransaction(new Transaction(getAccountNumber(), amount, time, false));
        return getBalance();
    }

    @Override
    public boolean isAccepted(double amount) {
        return amount >= 50000.0 && amount % 10000.0 == 0.0 && (getBalance() - amount - getFee(amount)) >= 50000.0 && amount <= MAX_WITHDRAW;
    }
}
