import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] array;
        while (true) {
            System.out.println("Nhập các phần tử của mảng:");
            String elementNumber = input.nextLine();
            if (checkedNumber(elementNumber)) {
                array = enterElementArray(Integer.parseInt(elementNumber));
                break;
            }
        }
        int answer = 0;
        String elementSearch;
        while (true) {
            System.out.println("Nhập phần tử muốn tìm kiếm:");
            elementSearch = input.nextLine();
            if (checkedNumber(elementSearch)) {
                answer = searchElementArray(array, Integer.parseInt(elementSearch));
                break;
            }
        }
        System.out.println("Tìm thấy phần tử " + elementSearch + " ở vị trí " + answer);
    }
    public static int[] enterElementArray(int number) {
        int[] array = new int[number];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < number; i++) {
            while (true) {
                String element = input.nextLine();
                if (checkedNumber(element)) {
                    array[i] = Integer.parseInt(element);
                    break;
                }
            }
        }
        return array;
    }
    public static int searchElementArray(int[] array, int number) {
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                answer = i;
            }
        }
        return answer;
    }
    public static boolean checkedNumber(String number) {
        String regex = "^\\d$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}