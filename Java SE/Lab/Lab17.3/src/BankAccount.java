import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private final Lock lock;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean done = false;
        while (!done) {
            lock.lock();
            try {
                balance += amount;
            } catch (Exception e) {
                System.out.println("Exception " + e.getMessage());
            } finally {
                lock.unlock();
            }
            done = true;
        }
    }
    public void withdraw(double amount) {
        boolean done = false;
        while (!done) {
            lock.lock();
            try {
                balance -= amount;
            } catch (Exception e) {
                System.out.println("Exception " + e.getMessage());
            } finally {
                lock.unlock();
            }
            done = true;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
