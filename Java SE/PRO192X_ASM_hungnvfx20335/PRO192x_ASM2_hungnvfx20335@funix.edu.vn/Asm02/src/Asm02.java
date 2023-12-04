import models.Account;
import models.Bank;
import models.Customer;

import java.util.Scanner;

public class Asm02 {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V2.0.0";
    public static final Scanner input = new Scanner(System.in);
    public static final Bank bank = new Bank();
    public static void main(String[] args) {
        displaySoftwareInformation();
        while (true) {
            String number = input.nextLine();
            if (checkNumber(number)) {
                int checkedNumber = Integer.parseInt(number);
                switch (checkedNumber) {
                    case 1:
                        addCustomerToTheBank();
                        break;
                    case 2:
                        addAccountForCustomer();
                        break;
                    case 3:
                        showListOfCustomer();
                        break;
                    case 4:
                        searchByCustomerCCCD();
                        break;
                    case 5:
                        searchByCustomerName();
                        break;
                    case 0:
                        System.exit(0);
                }
                System.out.print("Chọn chức năng: ");
            } else {
                System.out.print("Chọn chức năng: ");
            }
        }
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "         |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Thêm khách hàng                            |");
        System.out.println("| 2. Thêm tài khoản cho khách hàng              |");
        System.out.println("| 3. Hiển thị danh sách khách hàng              |");
        System.out.println("| 4. Tìm theo CCCD                              |");
        System.out.println("| 5. Tìm theo tên khách hàng                    |");
        System.out.println("| 0. Thoát                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }
    public static boolean checkNumber(String number) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(number);
            if (inputNumber > 5 || inputNumber < 0) {
                System.out.println("Nhập chức năng không đúng.");
                return false;
            }
            return true;
        } catch (NumberFormatException exception) {
            System.out.println("Nhập chức năng không đúng.");
            return false;
        }
    }
    public static void addCustomerToTheBank() {
        System.out.print("Nhập tên khách hàng: ");
        String name = input.nextLine();
        System.out.print("Nhập số CCCD: ");
        String customerID = input.nextLine();
        bank.addCustomer(new Customer(name, customerID));
    }
    public static void addAccountForCustomer() {
        while (true) {
            System.out.println("Nhập số CCCD khách hàng");
            String customerID = input.nextLine();
            if (bank.isCustomerExisted(customerID) != null) {
                while (true) {
                    System.out.println("Nhập mã số tài khoản gồm 6 chữ số");
                    String accountNumber = input.nextLine();
                    boolean checkAccount = bank.checkAccountNumber(accountNumber);

                    if (checkAccount) {
                        System.out.println("Nhập số dư:");
                        String balance = input.nextLine();
                        bank.addAccount(customerID, new Account(accountNumber, Double.parseDouble(balance)));
                        System.out.println("Thêm tài khoản thành công!");
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void showListOfCustomer() {
        bank.displayInformation();
    }
    public static void searchByCustomerCCCD() {
        System.out.println("Nhập số CCCD khách hàng");
        while (true) {
            String customerID = input.nextLine();
            if (bank.isCustomerExisted(customerID) != null) {
                bank.searchCustomerID(customerID);
                break;
            }
            else {
                System.out.println("Số CCCD không tồn tại");
                System.out.println("Nhập số CCCD khách hàng");
            }
        }
    }
    public static void searchByCustomerName() {
        System.out.println("Nhập số tên khách hàng");
        String name = input.nextLine();
        if (bank.isNameExisted(name) != null) {
            bank.searchName(name);
        }
        else {
            System.out.println("Tên không tồn tại");
            System.out.println("Nhập số tên khách hàng");
        }
    }
}