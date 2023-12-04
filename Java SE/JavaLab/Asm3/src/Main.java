import models.CreditAccount;
import models.Customer;
import models.DigitalBank;
import models.SavingsAccount;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String AUTHOR = "FX20335";
    private static final String VERSION = "@v3.0.0";
    private static final String BANK_ID = "HD001";
    private static final String BANK_NAME = "NGÂN HÀNG TRUNG NGUYÊN";
    private static final String CUSTOMER_ID = "030095001610";
    private static final String CUSTOMER_NAME = "NGUYỄN VĂN HÙNG";
    private static final DigitalBank digitalBank = new DigitalBank(BANK_ID, BANK_NAME);
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            displaySoftwareInformation();
            String select = input.nextLine();
            digitalBank.addCustomer(new Customer(CUSTOMER_ID, CUSTOMER_NAME));
            switch(select) {
                case "1" -> printInformationCustomer();
                case "2" -> addSavingsAccount();
                case "3" -> addCreditAccount();
                case "4" -> withdraw();
                case "5" -> printHistoryTransaction();
                case "6" -> System.exit(0);
            }
        }

    }
    public static void printInformationCustomer() {
        Customer customer = digitalBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            System.out.println(customer.printInformationCustomer());
        }
    }
    public static void addSavingsAccount() {
        while (true) {
            System.out.println("Nhập mã số tài khoản");
            String accountNumber = input.nextLine();
            if (validateAccount(accountNumber) && digitalBank.validateAccount(CUSTOMER_ID, accountNumber)) {
                while (true) {
                    System.out.println("Nhập số tiền trong tài khoản");
                    String balance = input.nextLine();
                    if (validateBalance(balance) && Double.parseDouble(balance) >= 50000.0) {
                        digitalBank.addAccount(CUSTOMER_ID, new SavingsAccount(accountNumber, Double.parseDouble(balance)));
                        break;
                    }
                }
                break;
            }
        }

    }
    public static boolean validateAccount(String accountNumber) {
        String regex = "^\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(accountNumber);
        return matcher.matches();
    }
    public static boolean validateBalance(String balance) {
        String regex = "^\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(balance);
        return matcher.matches();
    }
    public static void addCreditAccount() {
        while (true) {
            System.out.println("Nhập mã số tài khoản");
            String accountNumber = input.nextLine();
            if (validateAccount(accountNumber) && digitalBank.validateAccount(CUSTOMER_ID, accountNumber)) {
                while (true) {
                    System.out.println("Nhập số tiền trong tài khoản");
                    String balance = input.nextLine();
                    if (validateBalance(balance) && Double.parseDouble(balance) >= 50000.0) {
                        digitalBank.addAccount(CUSTOMER_ID, new CreditAccount(accountNumber, Double.parseDouble(balance)));
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void withdraw() {
        while (true) {
            System.out.println("Nhập mã số tài khoản");
            String accountNumber = input.nextLine();
            if (validateAccount(accountNumber) && !digitalBank.validateAccount(CUSTOMER_ID, accountNumber)) {
                while (true) {
                    System.out.println("Nhập số tiền muốn rút");
                    String balance = input.nextLine();
                    if (validateBalance(balance) && Double.parseDouble(balance) >= 50000.0) {
                        digitalBank.withdrawMoney(CUSTOMER_ID, accountNumber, Double.parseDouble(balance));
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void printHistoryTransaction() {
        digitalBank.printHistoryTransaction(CUSTOMER_ID);
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