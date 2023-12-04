package models;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class CreditAccount extends Account  implements Withdraw, ReportService{
    public static final double CREDIT_ACCOUNT_MAX_BALANCE = 1000000000.0;
    public static final double ACCOUNT_WITHDRAW_FEE_AMOUNT = 0.05;
    public static final double ACCOUNT_WITHDRAW_PREMIUM_FEE_AMOUNT = 0.01;
    public CreditAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public double withdraw(double amount) {
        if (isAccepted(amount)) {
            log(amount);
            addTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), amount,
                    java.time.LocalDateTime.now().toString(), true));
            return getBalance() - amount - getTransactionFee(amount);
        }
        return getBalance();
    }
    @Override
    public void log(double amount) {
        double balanceAmount = getBalance() - amount - getTransactionFee(amount);
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balanceAmount1 = currencyVN.format(balanceAmount);
        String amount1 = currencyVN.format(amount);
        String transactionFee = currencyVN.format(getTransactionFee(amount));

        System.out.println("+----------+-------------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DỊCH");
        System.out.printf("NGÀY G/D: %38s%n", java.time.LocalDateTime.now());
        System.out.printf("ATM ID: %40s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %41s%n", getAccountNumber());
        System.out.printf("SO TIEN: %39s%n", amount1);
        System.out.printf("SO DU: %41s%n", balanceAmount1);
        System.out.printf("PHI + VAT: %37s%n", transactionFee);
        System.out.println("+----------+-------------------------+----------+");
    }

    public double getTransactionFee(double amount) {
        double transactionFee;
        if (isPremium()) {
            transactionFee = amount * ACCOUNT_WITHDRAW_PREMIUM_FEE_AMOUNT;
        } else {
            transactionFee = amount * ACCOUNT_WITHDRAW_FEE_AMOUNT;
        }
        return transactionFee;
    }
    @Override
    public boolean isAccepted(double amount) {
        double balanceAmount = getBalance() - amount;
        if (amount <= CREDIT_ACCOUNT_MAX_BALANCE && amount % 10000.0 == 0.0 && balanceAmount >= 500000.0) {
            System.out.println("Bạn đã rút tiền thành công");
            return true;
        } else {
            addTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), amount,
                    java.time.LocalDateTime.now().toString(), false));
            System.out.println("Bạn rút tiền không thành công");
        }
        return false;
    }

    @Override
    public String displayAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balance = currencyVN.format(getBalance());
        return String.format("%-5s%-10s%-20s%-15s%-25s%n", "",getAccountNumber() + " |", "CREDIT ACCOUNT",
                "|                 ", balance);
    }
}
