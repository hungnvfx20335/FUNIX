package models;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

public class SavingsAccount extends Account  implements Withdraw, ReportService{
    public static final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000.0;
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public double withdraw(double amount) {
        if (isAccepted(amount)) {
            log(amount);
            addTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), amount,
                    java.time.LocalDateTime.now().toString(), true));
            return getBalance() - amount;
        }
        return getBalance();
    }
    @Override
    public void log(double amount) {
        double balanceAmount = getBalance() - amount;
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balanceAmount1 = currencyVN.format(balanceAmount);
        String amount1 = currencyVN.format(amount);

        System.out.println("+----------+-------------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DỊCH SAVINGS");
        System.out.printf("NGÀY G/D: %38s%n", java.time.LocalDateTime.now());
        System.out.printf("ATM ID: %40s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %41s%n", getAccountNumber());
        System.out.printf("SO TIEN: %39s%n", amount1);
        System.out.printf("SO DU: %41s%n", balanceAmount1);
        System.out.printf("PHI + VAT: %37s%n", "0.0 đ");
        System.out.println("+----------+-------------------------+----------+");
    }

    @Override
    public boolean isAccepted(double amount) {
        double balanceAmount = getBalance() - amount;
        if (isPremium() && amount % 10000.0 == 0.0 && balanceAmount >= 500000.0) {
            System.out.println("Bạn đã rút tiền thành công");
            return true;
        } else if (amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW && amount % 10000.0 == 0.0 && balanceAmount >= 500000.0) {
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
        return String.format("%-5s%-10s%-20s%-15s%-25s%n", "",getAccountNumber() + " |", "SAVINGS ACCOUNT",
                "|                 ", balance);
    }
}
