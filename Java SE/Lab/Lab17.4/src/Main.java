public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("123456", 1000.00);

        Thread thread1 = new Thread() {
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
        };
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bankAccount.deposit(203.75);
                    bankAccount.withdraw(100.00);
                    System.out.println("Một thread sẽ gửi vào tài khoản 203.75$ và sau đó rút ra 100$");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}