import models.Bank;
import models.SavingAccount;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

public class Main {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V4.0.0";
    public static final Scanner input = new Scanner(System.in);
    public static final String BANK_ID = "BANK001";
    public static final String BANK_NAME = "NGAN HANG TRUNG NGUYEN";
    public static final Bank bank = new Bank(BANK_ID, BANK_NAME);
    public static void main(String[] args) {
        while (true) {
            displaySoftwareInformation();
            String select = input.nextLine();
            switch (select) {
                case "1" -> viewCustomerList();
                case "2" -> enterCustomerList();
                case "3" -> addSavingsAccount();
                case "4" -> transferMoney();
                case "5" -> withdrawMoney();
                case "6" -> lookUpTransactionHistory();
                case "7" -> System.exit(0);
            }
        }
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "         |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Xem danh sách khách hàng                   |");
        System.out.println("| 2. Nhập danh sách khách hàng                  |");
        System.out.println("| 3. Thêm tài khoản ATM                         |");
        System.out.println("| 4. Chuyển tiền                                |");
        System.out.println("| 5. Rút tiền                                   |");
        System.out.println("| 6. Tra cứu lịch sử giao dịch                  |");
        System.out.println("| 7. Thoát                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Chọn chức năng: ");
    }
    public static void viewCustomerList() {
        bank.showInformationCustomers();
    }
    public static void enterCustomerList() {
        System.out.println("Nhập đường dẫn đến tệp:");
        String fileName = input.nextLine();
        bank.addCustomer(fileName);
    }
    public static void addSavingsAccount() {
        while (true) {
            System.out.println("Nhập mã số của khách hàng:");
            String customerID = input.nextLine();
            if (bank.isCustomerExisted(customerID)) {
                while (true) {
                    System.out.println("Nhập số tài khoản gồm 6 chữ số:");
                    String accountNumber = input.nextLine();
                    if (bank.checkAccountNumber(accountNumber)) {
                        if (bank.getCustomerByAccountNumber(accountNumber) == null) {
                            while (true) {
                                System.out.println("Nhập số dư tài khoản");
                                String balance = input.nextLine();
                                if (bank.checkAccountBalance(balance)) {
                                    if (bank.validateBalance(balance)) {
                                        bank.addSavingsAccount(customerID, new SavingAccount(customerID, accountNumber, Double.parseDouble(balance)));
                                        break;
                                    } else {
                                        System.out.println("Nhập số dư tài khoản >= 50.000đ");
                                    }
                                } else {
                                    System.out.println("Số dư tài khoản không hợp lệ");
                                }
                            }
                            break;

                        } else {
                            System.out.println("Tài khoản đã tồn tại");
                        }
                    } else {
                        System.out.println("Số tài khoản không hợp lệ");
                    }
                }
                break;
            } else {
                System.out.println("Không tìm thấy khách hàng " + customerID + " tác vụ không thành công");
            }
        }
    }
    public static void transferMoney() {
        while (true) {
            System.out.println("Nhập mã số của khách hàng:");
            String customerID = input.nextLine();
            if (bank.isCustomerExisted(customerID)) {
                bank.showInformationCustomer(customerID);
                while (true) {
                    System.out.println("Nhập số tài khoản gồm 6 chữ số:");
                    String accountNumber = input.nextLine();
                    if (bank.checkAccountNumber(accountNumber)) {
                        if (bank.getCustomerByAccountNumber(accountNumber) != null) {
                            while (true) {
                                System.out.println("Nhập số tài khoản nhận");
                                String accountNumberReceive = input.nextLine();
                                if (bank.checkAccountNumber(accountNumberReceive) && !accountNumberReceive.equals(accountNumber)) {
                                    if (bank.getCustomerByAccountNumber(accountNumberReceive) != null) {
                                        System.out.println("Gửi tiền đến tài khoản: " + accountNumberReceive + " | " +
                                                bank.getCustomerByAccountNumber(accountNumberReceive).getName());
                                        while (true) {
                                            System.out.println("Nhập số tiền muốn chuyển:");
                                            String balance = input.nextLine();
                                            if (bank.checkAccountBalance(balance)) {
                                                if (bank.validateBalance(balance)) {
                                                    Locale localeVn = new Locale("vi", "VN");
                                                    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVn);
                                                    String balanceReceive = currencyVN.format(Double.parseDouble(balance));
                                                    System.out.println("Xác nhận chuyển tiền " + balanceReceive + " từ tài khoản " + accountNumber +
                                                            " đến tài khoản " + accountNumberReceive + " (Y/N)");
                                                    String select = input.nextLine().toUpperCase();
                                                    if (select.equals("Y")) {
                                                        bank.transferMoney(bank.getCustomerByAccountNumber(accountNumberReceive)
                                                                        .getAccountByAccountNumber(accountNumberReceive),
                                                                customerID, accountNumber, Double.parseDouble(balance));
                                                        break;
                                                    } else if (select.equals("N")) {
                                                        System.out.println("Chuyển tiền không thành công");
                                                        break;
                                                    }
                                                } else {
                                                    System.out.println("Nhập số dư tài khoản >= 50.000đ");
                                                }
                                            } else {
                                                System.out.println("Số dư tài khoản không hợp lệ");
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    } else {
                        System.out.println("Số tài khoản không hợp lệ");
                    }
                }
                break;
            }
        }
    }

    public static void withdrawMoney() {
        while (true) {
            System.out.println("Nhập mã số của khách hàng:");
            String customerID = input.nextLine();
            if (bank.isCustomerExisted(customerID)) {
                bank.showInformationCustomer(customerID);
                while (true) {
                    System.out.println("Nhập số tài khoản gồm 6 chữ số:");
                    String accountNumber = input.nextLine();
                    if (bank.checkAccountNumber(accountNumber)) {
                        if (bank.getCustomerByAccountNumber(accountNumber) != null) {
                            while (true) {
                                System.out.println("Nhập số tiền muốn rút");
                                String balance = input.nextLine();
                                if (bank.checkAccountBalance(balance)) {
                                    if (bank.validateBalance(balance)) {
                                        try {
                                            bank.withdrawMoney(customerID, accountNumber, Double.parseDouble(balance));
                                        } catch (IOException exception) {
                                            System.out.println(exception.getMessage());
                                        }
                                        break;
                                    } else {
                                        System.out.println("Nhập số dư tài khoản >= 50.000đ");
                                    }
                                } else {
                                    System.out.println("Số dư tài khoản không hợp lệ");
                                }
                            }
                            break;
                        }
                    } else {
                        System.out.println("Số tài khoản không hợp lệ");
                    }
                }
                break;
            }
        }
    }
    public static void lookUpTransactionHistory() {
        while (true) {
            System.out.println("Nhập mã số của khách hàng:");
            String customerID = input.nextLine();
            if (bank.isCustomerExisted(customerID)) {
                bank.showInformationTransactionAccount(customerID);
                break;
            }
        }
    }
}