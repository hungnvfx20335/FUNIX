package models;

import dao.AccountDao;
import repository.TransferMoney;
import repository.WithdrawMoney;
import service.ReportService;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;


public class SavingAccount extends Account implements TransferMoney, WithdrawMoney, ReportService, Serializable {
    public static final long serialVersionUID = 1L;
    public static final double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000.0;
    public SavingAccount(String customerId,String accountNumber, double balance) {
        super(customerId, accountNumber, balance);
    }
    public String showInformationAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balance = currencyVN.format(getBalance());
        return String.format("%-5s%-10s%-20s%-15s%-25s%n", "",getAccountNumber() + " |", "SAVINGS ACCOUNT", "|                 ", balance);
    }
    @Override
    public boolean transfer(SavingAccount receiveAccount, double amount) throws IOException {
        if (isAccepted(amount)) {
            if (this.getAccountNumber().equals(receiveAccount.getAccountNumber())) {
                createTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), "     DEPOSIT     ",
                        amount, java.time.LocalDateTime.now().toString(), true));
                setBalance(getBalance() + amount);
                AccountDao.update(new SavingAccount(getCustomerId(), getAccountNumber(), getBalance()));
            } else {
                String pattern = "-";
                DecimalFormat decimalFormat = new DecimalFormat(pattern);
                String amountFormat = decimalFormat.format(amount);
                createTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), "     TRANSFERS   ",
                        Double.parseDouble(amountFormat), java.time.LocalDateTime.now().toString(), true));
                setBalance(getBalance() - amount);
                AccountDao.update(new SavingAccount(getCustomerId(), getAccountNumber(), getBalance()));
                System.out.println("Bạn đã chuyển tiền thành công, biên lai giao dịch:");
                transferReceipt(receiveAccount, amount);
            }


            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(double amount) throws IOException {
        if (isAccepted(amount)) {
            String pattern = "-";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            String amountFormat = decimalFormat.format(amount);
            createTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), "     WITHDRAW    ",
                    Double.parseDouble(amountFormat), java.time.LocalDateTime.now().toString(), true));
            setBalance(getBalance() - amount);
            AccountDao.update(new SavingAccount(getCustomerId(), getAccountNumber(), getBalance()));
            System.out.println("Bạn đã rút tiền thành công, biên lai giao dịch:");
            withdrawalReceipt(amount);
            return true;
        } else {

            createTransaction(new Transaction(String.valueOf(UUID.randomUUID()), getAccountNumber(), "     WITHDRAW    ",
                    amount, java.time.LocalDateTime.now().toString(), false));
        }
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {
        double balanceAmount = getBalance() - amount;
        if (isPremium() && amount % 10000.0 == 0.0 && balanceAmount >= 500000.0) {
            return true;
        } else return amount <= SAVINGS_ACCOUNT_MAX_WITHDRAW && amount % 10000.0 == 0.0 && balanceAmount >= 500000.0;
    }

    @Override
    public void withdrawalReceipt(double amount) {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balanceAmount = currencyVN.format(getBalance());
        String amountFormat = currencyVN.format(amount);
        System.out.println("+----------+-------------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DỊCH SAVINGS");
        System.out.printf("NGÀY G/D: %38s%n", java.time.LocalDateTime.now());
        System.out.printf("ATM ID: %40s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SỐ TK: %41s%n", getAccountNumber());
        System.out.printf("SỐ TIỀN RÚT: %35s%n", amountFormat);
        System.out.printf("SỐ DƯ TK: %38s%n", balanceAmount);
        System.out.printf("PHÍ + VAT: %37s%n", "0.0 đ");
        System.out.println("+----------+-------------------------+----------+");
    }

    @Override
    public void transferReceipt(SavingAccount receiveAccount, double amount) {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String balanceAmount = currencyVN.format(getBalance());
        String amountFormat = currencyVN.format(amount);
        System.out.println("+----------+-------------------------+----------+");
        System.out.printf("%30s%n", "BIÊN LAI GIAO DỊCH SAVINGS");
        System.out.printf("NGÀY G/D: %38s%n", java.time.LocalDateTime.now());
        System.out.printf("ATM ID: %40s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SỐ TK: %41s%n", getAccountNumber());
        System.out.printf("SỐ TK NHẬN: %36s%n", receiveAccount.getAccountNumber());
        System.out.printf("SỐ TIỀN CHUYỂN: %32s%n", amountFormat);
        System.out.printf("SỐ DƯ TK: %38s%n", balanceAmount);
        System.out.printf("PHÍ + VAT: %37s%n", "0.0 đ");
        System.out.println("+----------+-------------------------+----------+");
    }
}
