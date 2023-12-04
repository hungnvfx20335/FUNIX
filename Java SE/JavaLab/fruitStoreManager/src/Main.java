import models.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V1.0.0";
    public static final Scanner input = new Scanner(System.in);
    public static final ArrayList<Fruit> fruits = new ArrayList<>();
    public static final HashMap<String, ArrayList<Fruit>> customers = new HashMap<>();
    public static void main(String[] args) {
        while (true) {
            displayInformationSoftware();
            String select = input.nextLine();
            if (checkSelectFunction(select)) {
                switch (select) {
                    case "1":
                        enterFruit();
                        break;
                    case "2":
                        viewOrderFruit();
                        break;
                    case "3":
                        shoppingFruit();
                        break;
                    case "4":
                        System.out.println("Thoát chương trình!");
                        System.exit(0);
                }
            } else {
                System.out.println("Nhập đúng kiểu dữ liệu số.");
            }
        }
    }
    public static void displayInformationSoftware() {
        System.out.println("+----------+-------------------------+--------------------+");
        System.out.println("| " + "HỆ THỐNG CỬA HÀNG TRÁI CÂY" + " | " + AUTHOR + VERSION + "     |");
        System.out.println("+----------+-------------------------+--------------------+");
        System.out.println("| 1. Tạo trái cây                                         |");
        System.out.println("| 2. Xem đơn đặt hàng                                     |");
        System.out.println("| 3. Khách hàng mua sắm                                   |");
        System.out.println("| 0. Thoát                                                |");
        System.out.println("+----------+-------------------------+--------------------+");
        System.out.print("Chọn chức năng: ");
    }
    public static boolean checkSelectFunction(String select) {
        String regex = "^\\d{1,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(select);
        return matcher.matches();
    }
    public static void enterFruit() {
        while (true) {
            System.out.println("Nhập mã trái cây:");
            String fruitCode = input.nextLine();
            System.out.println("Nhập tên trái cây:");
            String fruitName = input.nextLine();
            System.out.println("Nhập giá của trái cây:");
            String fruitPrice = input.nextLine();
            System.out.println("Nhập số lượng của trái cây:");
            String fruitQuantity = input.nextLine();
            System.out.println("Nhập nguồn gốc của trái cây:");
            String fruitOrigin = input.nextLine();
            fruits.add(new Fruit(fruitCode, fruitName, fruitPrice, fruitQuantity, fruitOrigin));
            System.out.println("Người dùng chọn Y để tiếp tục.");
            System.out.println("Người dùng chọn N chương trình sẽ trả về màn hình chính.");
            String select = input.nextLine().toUpperCase();
            switch (select) {
                case "Y":
                    break;
                case "N":
                    return;
            }
        }

    }
    public static void viewOrderFruit() {
        for (Map.Entry<String, ArrayList<Fruit>> entry : customers.entrySet()) {
            int sumNumberMoney = 0;
            int count = 0;
            System.out.println("Khách hàng: " + entry.getKey());
            System.out.printf("%-20s%-20s%-20s%-20s%n", "Sản phẩm trái cây", "Số lượng trái cây", "Giá trái cây", "Số tiền");
            for (int i = 0; i < entry.getValue().size(); i++) {
                int numberMoney = Integer.parseInt(entry.getValue().get(count).getFruitPrice()) * Integer.parseInt(entry.getValue().get(count).getFruitQuantity());
                System.out.printf("%-20s%-20s%-20s%-20d%n", entry.getValue().get(count).getFruitName(), entry.getValue().get(count).getFruitQuantity(),
                        entry.getValue().get(count).getFruitPrice(), numberMoney);;
                sumNumberMoney += numberMoney;
                count++;
            }
            System.out.println("Tổng số tiền: " + sumNumberMoney);
        }
    }
    public static void shoppingFruit() {
        ArrayList<Fruit> listFruit = new ArrayList<>();
        while (true) {
            displayListFruit();
            System.out.println("Bạn chọn mã trái cây muốn mua:");
            String fruitCode = input.nextLine();
            for (Fruit fruit : fruits) {
                if (fruit.getFruitCode().contains(fruitCode)) {
                    System.out.println("Bạn đã chọn trái cây: " + fruit.getFruitName());
                    while (true) {
                        System.out.println("Vui lòng nhập số lượng: ");
                        String fruitQuantity = input.nextLine();
                        if (Integer.parseInt(fruitQuantity) <= Integer.parseInt(fruit.getFruitQuantity())) {
                            listFruit.add(new Fruit(fruitCode, fruit.getFruitName(), fruit.getFruitPrice(), fruitQuantity, fruit.getFruitQuantity()));
                            break;
                        }
                    }
                }
            }
            System.out.println("Khách hàng chọn Y để đặt hàng.");
            System.out.println("Khách hàng chọn N để quy lại danh sách trái cây.");
            String select = input.nextLine().toUpperCase();
            switch (select) {
                case "Y":
                    System.out.print("Nhập tên của bạn: ");
                    String customerName = input.nextLine();
                    customers.put(customerName, listFruit);
                    return;
                case "N":
                    break;
            }
        }
    }
    public static void displayListFruit() {
        System.out.println("Danh sách trái cây:");
        System.out.printf("%-15s%-20s%-20s%-20s%-20s%n", "Mã trái cây", "Tên trái cây", "Giá trái cây", "Số lượng trái cây",
                "Nguồn gốc trái cây");

        for (Fruit fruit : fruits) {
            System.out.println(fruit.toString());
        }
    }
}