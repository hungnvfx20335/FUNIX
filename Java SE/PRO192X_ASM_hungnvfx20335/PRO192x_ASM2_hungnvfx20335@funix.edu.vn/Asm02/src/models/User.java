package models;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String customerID;

    public User(String name, String customerID) {
        this.setName(name);
        this.setCustomerID(customerID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        if (checkCccdNumber(customerID)) {
            this.customerID = customerID;
            System.out.println("Đã thêm khách hàng " +  customerID + " vào danh sách!");
        } else {
            updateCustomerId();
        }
    }
    public void updateCustomerId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập không đúng định dạng CCCD hoặc nhập NO để thoát!");
        System.out.print("Nhập số CCCD: ");
        while (true) {
            String checkedCustomerID = input.nextLine();
            if (checkCccdNumber(checkedCustomerID)) {
                this.customerID = checkedCustomerID;
                System.out.println("Đã thêm khách hàng " +  customerID + " vào danh sách!");
                break;
            } else if (checkedCustomerID.equals("NO")) {
                System.out.println("Nhập NO thoát!");
                System.exit(0);
            }
            else {
                System.out.println("Vui lòng nhập lại hoặc NO để thoát!");
                System.out.print("Nhập số CCCD: ");
            }
        }
    }
    public static boolean checkCccdNumber(String number) {
        String regex = "^\\d{12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
