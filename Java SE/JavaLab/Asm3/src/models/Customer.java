package models;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Customer extends User{
    private ArrayList<Account> accountArrayList;
    public Customer(String customerId, String customerName) {
        super(customerId, customerName);
        this.accountArrayList = new ArrayList<>();
    }
    public String printInformationCustomer() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String totalAccountBalance = numberFormat.format(getTotalAccountBalance());
        StringBuilder informationAccount = new StringBuilder(String.format("%15s%20s%10s%20s%n", getCustomerId() + " |",
                getCustomerName() + " |", checkCustomerPremium() + " |", totalAccountBalance));
        for (int i = 0; i < accountArrayList.size(); i++) {
            informationAccount.append(" ").append(i + 1).append(accountArrayList.get(i).printInformationAccount());
        }
        return informationAccount.toString();
    }
    public void printInformationTransaction() {
        System.out.println(printInformationCustomer());
        System.out.printf("%15s%30s%25s%31s%5s%n", "    Account |", "Amount |",
                "    Time |", "                      Transaction Id |", " Status");
        for(Account account : accountArrayList) {
            System.out.println(account.printHistoryTransaction());
        }
    }
    public double getTotalAccountBalance() {
        double balance = 0.0;
        for (Account account : accountArrayList) {
            balance += account.getBalance();
        }
        return balance;
    }
    public String checkCustomerPremium() {
        String answer = "Normal ";
        if (getTotalAccountBalance() >= 10000000.0) {
            answer = "Premium";
        }
        return answer;
    }
    public boolean validateAccount(String accountNumber) {
        for (Account account : accountArrayList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return false;
            }
        }
        return true;
    }
    public void addAccount(Account account) {
        this.accountArrayList.add(account);
        System.out.println("Thêm tài khoản thành công");
    }
    public void withdrawMoney(String accountNumber, double amount) {
        for (Account account : accountArrayList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                try {
                    SavingsAccount savingsAccount = (SavingsAccount) account;
                    double balance = savingsAccount.withdraw(amount);
                    savingsAccount.setBalance(balance);
                } catch (ClassCastException e) {
                    CreditAccount creditAccount = (CreditAccount) account;
                    double balance = creditAccount.withdraw(amount);
                    creditAccount.setBalance(balance);
                }
                break;
            }
        }
    }

    private ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }

    private void setAccountArrayList(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;
    }
}
