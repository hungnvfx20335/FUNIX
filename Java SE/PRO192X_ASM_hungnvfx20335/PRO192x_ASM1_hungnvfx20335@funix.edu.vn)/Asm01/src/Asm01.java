import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asm01 {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V1.0.0";
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displaySoftwareInformation();
            String number = input.nextLine();
            if (checkInputNumber(number)) {
                String select = input.nextLine();
                switch (select) {
                    case "1" -> enterFunction();
                    case "0" -> System.exit(0);
                }
            }
        }
    }
    public static void enterFunction() {
        while (true) {
            displayAuthentication();
            String select = input.nextLine();
            switch (select) {
                case "1" -> sixCharacterAuthenticationType();
                case "2" -> threeCharacterAuthenticationType();
                case "0" -> System.exit(0);
            }
        }
    }
    public static boolean checkSixCharacterCode(String string, String code) {
        if (string.equals(code)) {
            return true;
        } else if (string.equals("NO")) {
            System.out.println("Nhập NO thoát!");
            System.exit(0);
        } else {
            System.out.println("Mã xác thực không đúng. Vui lòng nhập lại hoặc NO để thoát!");
            return false;
        }
        return false;
    }
    public static void threeCharacterAuthenticationType() {
        int randomCode = (int)(Math.random() * 900) + 100;
        System.out.println("Nhập mã xác thực: " + randomCode);
        while (true) {
            String verificationCode = input.nextLine();
            if (checkVerificationCode(verificationCode, randomCode)) {
                inputCCD();
                break;
            }
        }
    }
    public static void sixCharacterAuthenticationType() {
        String randomAlphanumericCode = getAlphanumeric(6);
        System.out.println("Nhập mã xác thực: " + randomAlphanumericCode);
        while (true) {
            String verificationCode = input.nextLine();
            if (checkSixCharacterCode(verificationCode, randomAlphanumericCode)) {
                inputCCD();
                break;
            }
        }
    }
    public static void inputCCD() {
        while (true) {
            System.out.print("Nhập số CCCD: ");
            String cccdNumber = input.nextLine();
            if (checkCccdNumber(cccdNumber)) {
                while (true) {
                    displayFunction();
                    String functionNumber = input.nextLine();
                    if (checkInputNumber(functionNumber)) {
                        String select = input.nextLine();
                        switch (select) {
                            case "1" -> System.out.println("Nơi sinh: " + showAddress(cccdNumber));
                            case "2" -> System.out.println(displayYearOfBirthGender(cccdNumber));
                            case "3" -> System.out.println("Số ngẫu nhiên: " + displayRandomNumber(cccdNumber));
                            case "0" -> System.exit(0);
                        }
                    }
                }
            }
            else {
                System.out.print("Nhập số CCCD: ");
            }
        }
    }
    public static String getAlphanumeric(int n) {
        String alphanumericString = "01xyz2ABC3RjklSTUmV4qrs5DEF6tuv7WXYZnop8GHI9abcJKLdefMNOghiPQ";
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(Math.random() * alphanumericString.length());
            stringBuilder.append(alphanumericString.charAt(index));
        }
        return stringBuilder.toString();
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "         |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.println("| 1. Nhap CCCD                                  |");
        System.out.println("| 0. Thoat                                      |");
        System.out.println("+----------+-------------------------+----------+");
        System.out.print("Nhập chức năng: ");
    }
    public static boolean checkInputNumber(String number) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public static boolean checkVerificationCode(String number, int code) {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(number);
            if (inputNumber == code) {
                return true;
            }
        } catch (NumberFormatException exception) {
            if (number.equals("NO")) {
                System.out.println("Nhập NO thoát!");
                System.exit(0);
            }
            System.out.println("Mã xác thực không đúng. Vui lòng nhập lại hoặc NO để thoát!");
            return false;
        }
        return false;
    }
    public static boolean checkCccdNumber(String number) {
        String regex  = "^\\d{12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public static String showAddress(String number) {
        String firstThreeCharacter = number.substring(0, 3);
        HashMap<String, String> province = new HashMap<>();
        province.put("001", "Hà Nội");
        province.put("002", "Hà Giang");
        province.put("004", "Cao Bằng");
        province.put("006", "Bắc Kạn");
        province.put("008", "Tuyên Quang");
        province.put("010", "Lào Cai");
        province.put("011", "Điện Biên");
        province.put("012", "Lai Châu");
        province.put("014", "Sơn La");
        province.put("015", "Yên Bái");
        province.put("017", "Hòa Bình");
        province.put("019", "Thái Nguyên");
        province.put("020", "Lạng Sơn");
        province.put("022", "Bắc Giang");
        province.put("024", "Quảng Ninh");
        province.put("025", "Phú Thọ");
        province.put("026", "Vĩnh Phúc");
        province.put("027", "Bắc Ninh");
        province.put("030", "Hải Dương");
        province.put("031", "Hải Phòng");
        province.put("033", "Hưng Yên");
        province.put("034", "Thái Bình");
        province.put("035", "Hà Nam");
        province.put("036", "Nam Định");
        province.put("037", "Ninh Bình");
        province.put("038", "Thanh Hóa");
        province.put("040", "Nghệ An");
        province.put("042", "Hà Tĩnh");
        province.put("044", "Quảng Bình");
        province.put("045", "Quảng Trị");
        province.put("046", "Thừa Thiên Huế");
        province.put("048", "Đà Nẵng");
        province.put("049", "Quảng Nam");
        province.put("051", "Quảng Ngãi");
        province.put("052", "Bình Định");
        province.put("054", "Phú Yên");
        province.put("056", "Khánh Hòa");
        province.put("058", "Ninh Thuận");
        province.put("060", "Bình Thuận");
        province.put("062", "Kon Tum");
        province.put("064", "Gia Lai");
        province.put("066", "ĐắK Lắk");
        province.put("067", "Đắk Nông");
        province.put("068", "Lâm Đồng");
        province.put("070", "Bình Phước");
        province.put("072", "Tây Ninh");
        province.put("074", "Bình Dương");
        province.put("075", "Đồng Nai");
        province.put("077", "Bà Rịa Vũng Tàu");
        province.put("079", "Hồ Chí Minh");
        province.put("080", "Long An");
        province.put("082", "Tiền Giang");
        province.put("083", "Bến Tre");
        province.put("084", "Trà Vinh");
        province.put("086", "Vĩnh Long");
        province.put("087", "Đồng Tháp");
        province.put("089", "An Giang");
        province.put("091", "Kiên Giang");
        province.put("092", "Cần Thơ");
        province.put("093", "Hậu Giang");
        province.put("094", "Sóc Trăng");
        province.put("095", "Bạc Liêu");
        province.put("096", "Cà Mau");
        return province.get(firstThreeCharacter);
    }
    public static String displayYearOfBirthGender(String number) {
        String firstCharacter = number.substring(3, 4);
        String nextCharacter = number.substring(4, 6);
        HashMap<String, String> century = new HashMap<>();
        HashMap<String, String> gender = new HashMap<>();
        gender.put("0", "Nam");
        gender.put("1", "Nữ");
        gender.put("2", "Nam");
        gender.put("3", "Nữ");
        gender.put("4", "Nam");
        gender.put("5", "Nữ");
        gender.put("6", "Nam");
        gender.put("7", "Nữ");
        gender.put("8", "Nam");
        gender.put("9", "Nữ");
        century.put("0", "19");
        century.put("1", "19");
        century.put("2", "20");
        century.put("3", "20");
        century.put("4", "21");
        century.put("5", "21");
        century.put("6", "22");
        century.put("7", "22");
        century.put("8", "23");
        century.put("9", "23");
        return "Giới tính: " + gender.get(firstCharacter) + " | Năm sinh: " + century.get(firstCharacter) + nextCharacter;
    }
    public static String displayRandomNumber(String number) {
        return number.substring(7);
    }
    public static void displayFunction() {
        System.out.println("| 1. Kiểm tra nơi sinh");
        System.out.println("| 2. Kiểm tra năm sinh, giới tính");
        System.out.println("| 3. Kiểm tra số ngẫu nhiên");
        System.out.println("| 0. Thoát");
        System.out.print("Chọn chức năng: ");
    }
    public static void displayAuthentication() {
        System.out.println("| 1. Chọn mã bảo mật 6 ký tự");
        System.out.println("| 2. Chọn mã bảo mật 3 ký tự");
        System.out.println("| 0. Thoát");
        System.out.print("Chọn mã bảo mật: ");
    }
}