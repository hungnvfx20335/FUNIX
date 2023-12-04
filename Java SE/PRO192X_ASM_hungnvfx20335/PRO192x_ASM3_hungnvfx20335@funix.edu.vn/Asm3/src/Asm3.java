import models.*;

import java.util.Scanner;

public class Asm3 {
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "030095001610";
    private static final String NAME = "NGUYEN VAN HUNG";
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V3.0.0";
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        // Khởi tạo đối tượng DigitalCustomer
        activeBank.addCustomer(new DigitalCustomer(NAME, CUSTOMER_ID));
        while (true) {
            displaySoftwareInformation();
            String select = input.nextLine();
            switch (select) {
                case "1":
                    displayInformationCustomer();
                    break;
                case "2":
                    addSavingsAccount();
                    break;
                case "3":
                    addCreditAccount();
                    break;
                case "4":
                    withdrawMoney();
                    break;
                case "5":
                    transactionHistory();
                    break;
                case "6":
                    System.exit(0);
            }
        }
    }
    public static void displayInformationCustomer() {
        activeBank.getCustomerById(CUSTOMER_ID);
        activeBank.displayInformationCustomer();
    }
    public static void addSavingsAccount() {
        while (true) {
            System.out.println("Nhập mã số tài khoản gồm 6 chữ số");
            String accountNumber = input.nextLine();
            if (activeBank.validateAccount(CUSTOMER_ID, accountNumber)) {
                while (true) {
                    System.out.println("Nhập số dư");
                    String balance = input.nextLine();
                    if (activeBank.validateBalance(balance)) {
                        activeBank.addASavingsAccount(CUSTOMER_ID, new SavingsAccount(accountNumber, Double.parseDouble(balance)));
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void addCreditAccount() {
        while (true) {
            System.out.println("Nhập mã số tài khoản gồm 6 chữ số");
            String accountNumber = input.nextLine();
            if (activeBank.validateAccount(CUSTOMER_ID, accountNumber)) {
                while (true) {
                    System.out.println("Nhập số dư");
                    String balance = input.nextLine();
                    if (activeBank.validateBalance(balance)) {
                        activeBank.addCreditAccount(CUSTOMER_ID, new CreditAccount(accountNumber, Double.parseDouble(balance)));
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void withdrawMoney() {
        while (true) {
            System.out.println("Nhập mã số tài khoản gồm 6 chữ số");
            String accountNumber = input.nextLine();
            if (activeBank.isAccountExisted(CUSTOMER_ID, accountNumber)) {
                while (true) {
                    System.out.println("Nhập số tiền muốn rút");
                    String balance = input.nextLine();
                    if (activeBank.validateBalance(balance)) {
                        activeBank.withdrawMoneyAccount(CUSTOMER_ID,
                                new Account(accountNumber, Double.parseDouble(balance)));
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void transactionHistory() {
        activeBank.displayInformationTransactionAccount();
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "         |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Thông tin khách hàng                       |");
        System.out.println("| 2. Thêm tài khoản ATM                         |");
        System.out.println("| 3. Thêm tài khoản tín dụng                    |");
        System.out.println("| 4. Rút tiền                                   |");
        System.out.println("| 5. Lịch sử giao dịch                          |");
        System.out.println("| 6. Thoát                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }
}