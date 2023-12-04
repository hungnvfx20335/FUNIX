package models;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Customer extends User{
    private ArrayList<Account> accounts;
    public Customer(String name, String customerId) {
        super(name, customerId);
        this.setAccounts(new ArrayList<>());
    }
    public String isPremiumAccount() {
        String answer = "   Normal    ";
        for (Account account : getAccounts()) {
            if (account.isPremium()) {
                answer = "   Premium   ";
            }
        }
        return answer;
    }
    public Account getAccountByAccountNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public boolean isAccountExisted(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public String displayInformationAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String totalAccountBalance = currencyVN.format(getTotalAccountBalance());
        StringBuilder customerInformation = new StringBuilder(String.format("%-15s%-20s%-15s%-25s%n", getCustomerId() + " |  ", getName(),
                "| " + isPremiumAccount() + " | ", totalAccountBalance));
        for (int i = 0; i < accounts.size(); i++) {
            Account account = this.getAccounts().get(i);
            customerInformation.append(i + 1).append(account.displayAccount());
        }
        return customerInformation.toString();
    }
    public double getTotalAccountBalance() {
        double answer = 0.0;
        for (Account account : getAccounts()) {
            answer += account.getBalance();
        }
        return answer;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
