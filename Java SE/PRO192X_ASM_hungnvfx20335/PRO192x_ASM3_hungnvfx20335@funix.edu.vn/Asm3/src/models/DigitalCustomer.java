package models;


import java.text.NumberFormat;
import java.util.Locale;

public class DigitalCustomer extends Customer{

    public DigitalCustomer(String name, String customerId) {
        super(name, customerId);
    }
    public void addSavingsAccount(SavingsAccount newAccount) {
        if (getAccountByAccountNumber(newAccount.getAccountNumber()) == null) {
            getAccounts().add(newAccount);
        } else {
            System.out.println("Tài khoản đã tồn tại");
        }
    }
    public void addCreditAccount(CreditAccount newAccount) {
        if (getAccountByAccountNumber(newAccount.getAccountNumber()) == null) {
            getAccounts().add(newAccount);
        } else {
            System.out.println("Tài khoản đã tồn tại");
        }
    }
    public void withdrawMoneyAccount(Account withdrawAccount) {
        for (int i = 0; i < getAccounts().size(); i++) {
            Account account = this.getAccounts().get(i);
            if (account.getAccountNumber().equals(withdrawAccount.getAccountNumber())) {
                try {
                    SavingsAccount savingsAccount = (SavingsAccount) this.getAccounts().get(i);
                    savingsAccount.setBalance(savingsAccount.withdraw(withdrawAccount.getBalance()));
                } catch (ClassCastException classCastException) {
                    CreditAccount creditAccount = (CreditAccount) this.getAccounts().get(i);
                    creditAccount.setBalance(creditAccount.withdraw(withdrawAccount.getBalance()));
                }
            }
        }
    }
    public String displayInformationTransactionAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String totalAccountBalance = currencyVN.format(getTotalAccountBalance());
        StringBuilder customerInformation = new StringBuilder(String.format("%-15s%-20s%-15s%-25s%n", getCustomerId() + " |  ", getName(),
                "| " + isPremiumAccount() + " | ", totalAccountBalance));
        for (int i = 0; i < getAccounts().size(); i++) {
            Account account = this.getAccounts().get(i);
            customerInformation.append(i + 1).append(account.displayAccount());
        }
        customerInformation.append(String.format
                ("\n%-15s%-20s%-30s%-40s%5s%n", "Account", "Amount", "Time", "Transaction ID", "Status"));
        for (int i = 0; i < getAccounts().size(); i++) {
            Account account = this.getAccounts().get(i);
            customerInformation.append(account.displayTransaction());
        }
        return customerInformation.toString();
    }
}
