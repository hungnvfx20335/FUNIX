public class Multithreading implements Runnable{
    public static final BankAccount bankAccount = new BankAccount("123456", 1000.00);
    @Override
    public void run() {
        try {
            bankAccount.deposit(300.00);
            bankAccount.withdraw(50.00);
            System.out.println("Một thread sẽ gửi vào tài khoản 300$ và sau đó rút ra 50$");
        } catch (Exception exception) {
            System.out.println("Exception is caught");
        }
    }
}
