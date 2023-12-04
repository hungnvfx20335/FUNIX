package models;
import dao.AccountDao;
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Customer extends User implements Serializable {
    public static final long serialVersionUID = 1L;

    public Customer(String customerId, String name) {
        super(customerId, name);
    }
    public String showInformationAccount() {
        Locale localeVn = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
        String totalAccountBalance = currencyVN.format(getTotalAccountBalance());
        StringBuilder customerInformation = new StringBuilder(String.format("%-15s%-20s%-15s%-25s%n", getCustomerId() + " |  ", getName(),
                "| " + isPremiumAccount() + " | ", totalAccountBalance));
        int number = 0;
        for (int i = 0; i < AccountDao.listAccount().size(); i++) {
            Account account = AccountDao.listAccount().get(i);
            if (this.getCustomerId().equals(account.getCustomerId())) {
                number = number + 1;
                customerInformation.append(number).append(account.showInformationAccount());
            }
        }
        return customerInformation.toString();
    }
    public String showInformationTransactionAccount() {
        StringBuilder informationTransactionAccount = new StringBuilder();
        informationTransactionAccount.append(showInformationAccount()).append(String.format
                ("\n%-15s%-15s%-20s%-30s%-40s%5s%n", "  Account", " Transaction Type ", "  Amount", "  Time", "  Transaction ID", " Status"));
        AccountDao.listAccount().forEach(account ->
                {
                    if (this.getCustomerId().equals(account.getCustomerId())) {
                        informationTransactionAccount.append(account.displayTransaction());
                    }
                });
        return informationTransactionAccount.toString();
    }
    public void addSavingsAccount(SavingAccount savingAccount) {
        ArrayList<Account> accounts = AccountDao.listAccount();
        accounts.add(savingAccount);
        System.out.println("Thêm tài khoản: " + savingAccount.getAccountNumber() + " thành công");
        try {
            AccountDao.save(accounts);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public double getTotalAccountBalance() {
        double answer = 0.0;
        for (Account account : AccountDao.listAccount()) {
            if (this.getCustomerId().equals(account.getCustomerId())) {
                answer += account.getBalance();
            }
        }
        return answer;
    }
    public String isPremiumAccount() {
        String answer = "   Normal    ";
        for (Account account : AccountDao.listAccount()) {
            if (this.getCustomerId().equals(account.getCustomerId()) && account.isPremium()) {
                answer = "   Premium   ";
            }
        }
        return answer;
    }
    public SavingAccount getAccountByAccountNumber(String accountNumber) {
        for (Account account : AccountDao.listAccount()) {
            if (account.getAccountNumber().equals(accountNumber) && account.getCustomerId().equals(this.getCustomerId())) {
                return (SavingAccount) account;
            }
        }
        return null;
    }

    public void transferMoneyAccount(SavingAccount savingAccountReceive, String accountNumber, double amount) throws IOException {
        for (Account account : AccountDao.listAccount()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                SavingAccount savingAccount = (SavingAccount) account;
                if (savingAccount.transfer(savingAccountReceive, amount)) {
                    savingAccountReceive.transfer(savingAccountReceive, amount);
                } else {
                    System.out.println("Bạn đã chuyển tiền thất bại");
                }
            }
        }
    }

    public void withdrawMoneyAccount(String accountNumber, double amount) throws IOException {
        for (Account account : AccountDao.listAccount()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                SavingAccount savingAccount = (SavingAccount) account;
                if (!savingAccount.withdraw(amount)) {
                    System.out.println("Bạn rút tiền không thành công");
                }
            }
        }
    }
}
