package dao;
import models.Account;
import service.BinaryFileService;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountDao implements Serializable {
    public static final long serialVersionUID = 1L;
    private static final String path = FileSystems.getDefault().getPath("src\\store\\accounts.dat").toAbsolutePath().toString();
    private static final int MAX_THREAD = 10;

    public static void save(ArrayList<Account> accounts) throws IOException {
        BinaryFileService.writeFile(path, accounts);
    }
    public static ArrayList<Account> listAccount() {
        return BinaryFileService.readFile(path);
    }
    public static void update(Account editAccount) throws IOException {
        ArrayList<Account> accounts = BinaryFileService.readFile(path);
        boolean hasExisted = accounts.stream().anyMatch(account -> account.getAccountNumber().equals(editAccount.getAccountNumber()));
        ArrayList<Account> updatedAccounts;
        if (!hasExisted) {
            updatedAccounts = new ArrayList<>(accounts);
            updatedAccounts.add(editAccount);
        } else {
            updatedAccounts = new ArrayList<>();
            ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);
            for (Account account : accounts) {
                Thread thread = new Thread(() -> {
                    try {
                        if (account.getAccountNumber().equals(editAccount.getAccountNumber())) {
                            updatedAccounts.add(editAccount);
                        } else {
                            updatedAccounts.add(account);
                        }
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                });
                executorService.execute(thread);
            }
        }
        BinaryFileService.writeFile(path, updatedAccounts);
    }
}
