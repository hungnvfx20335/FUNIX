
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V4.0.0";
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displaySoftwareInformation();
            String input = enterBaseNumberInput();
            String output = enterBaseNumberOutput(input);
            String value = enterValueInput();
            if (input.equals("2") && output.equals("3")) {
                printDECToHEX(value);
            }
            if (input.equals("3") && output.equals("2")) {
                printHEXToDEC(value);
            }
            if (input.equals("2") && output.equals("1")) {
                printDECToBIN(value);
            }
            if (input.equals("1") && output.equals("2")) {
                printBINToDEC(value);
            }
            System.out.println("Người dùng muốn thoát chương trình nhập N");
            String select = scanner.nextLine().toUpperCase();
            if (select.equals("N")) {
                System.exit(0);
            }
        }
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+--------------------+-----------------------------------+--------------------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "                                       |");
        System.out.println("+--------------------+-----------------------------------+--------------------+");
        System.out.println("| 1. Chọn đầu vào số cơ sở (1: nhị phân, 2: thập phân, 3: thập lục phân)      |");
        System.out.println("| 2. Chọn đầu ra số cơ sở (1: nhị phân, 2: thập phân, 3: thập lục phân)       |");
        System.out.println("| 3. Người dùng nhập giá trị đầu vào                                          |");
        System.out.println("| 4. Quá trình lập trình và in giá trị đầu ra                                 |");
        System.out.println("| 5. Thoát                                                                    |");
        System.out.println("+--------------------+-----------------------------------+--------------------+");
        System.out.print("Chọn chức năng: ");
    }
    public static String enterBaseNumberInput() {
        while (true) {
            System.out.println("Chọn đầu vào số cơ sở (1: nhị phân, 2: thập phân, 3: thập lục phân)");
            String select = scanner.nextLine();
            switch (select) {
                case "1" -> {
                    return "1";
                }
                case "2" -> {
                    return "2";
                }
                case "3" -> {
                    return "3";
                }
            }
        }
    }
    public static String enterBaseNumberOutput(String input) {
        while (true) {
            System.out.println("Chọn đầu ra số cơ sở (1: nhị phân, 2: thập phân, 3: thập lục phân)");
            String select = scanner.nextLine();
            if (!select.equals(input)) {
                switch (select) {
                    case "1" -> {
                        return "1";
                    }
                    case "2" -> {
                        return "2";
                    }
                    case "3" -> {
                        return "3";
                    }
                }
            } else {
                System.out.println("Chọn khác đầu ra số cơ sở " + input);
            }
        }
    }
    public static String enterValueInput() {
        while (true) {
            System.out.println("Nhập giá trị đầu vào");
            String input = scanner.nextLine();
            if (validateInput(input)) {
                return input;
            }
        }
    }
    public static boolean validateInput(String value) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
    public static void printDECToHEX(String value) {
        System.out.println(value + "(dec) = ? (hex)");
        int number = Integer.parseInt(value);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (number != 0) {
            System.out.println(number + " : 16 = " + number / 16 + " remainder " + number % 16);
            arrayList.add(number % 16);
            number = number / 16;
        }
        StringBuilder result = new StringBuilder();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            result.append(arrayList.get(i));
        }
        System.out.println(value + "(dec) = " +  result + " (hex)");
    }
    public static void printHEXToDEC(String value) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = value.length() - 1; i >= 0; i--) {
            arrayList.add(Integer.parseInt(String.valueOf(value.charAt(i))));
        }
        int answer = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            answer += arrayList.get(i) * Math.pow(16, i);
        }
        System.out.println("Convert from " + value + " (HEX) to " + answer + " DEC");
    }

    public static void printDECToBIN(String value) {
        System.out.println(value + "(dec) = ? (bin)");
        int number = Integer.parseInt(value);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (number != 0) {
            System.out.println(number + " : 2 = " + number / 2 + " remainder " + number % 2);
            arrayList.add(number % 2);
            number = number / 2;
        }
        StringBuilder result = new StringBuilder();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            result.append(arrayList.get(i));
        }
        System.out.println(value + "(dec) = " +  result + " (hex)");
    }
    public static void printBINToDEC(String value) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = value.length() - 1; i >= 0; i--) {
            arrayList.add(Integer.parseInt(String.valueOf(value.charAt(i))));
        }
        int answer = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            answer += arrayList.get(i) * Math.pow(2, i);
        }
        System.out.println("Convert from " + value + " (BIN) to " + answer + " DEC");
    }
}