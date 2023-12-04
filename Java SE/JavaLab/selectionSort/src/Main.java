import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử của mảng:");

        while(input.hasNextLine()) {
            String numberElementArray = input.nextLine();
            if (checkElementArray(numberElementArray)) {
                int[] array =enterElementArray(Integer.parseInt(numberElementArray));
                displayElementArray(array);
                array = sortedElementArray(array);
                displayElementArray(array);
            } else {
                System.out.println("Nhập không đúng kiểu dữ liệu số lượng phần tử của mảng");
                System.out.println("Nhập số lượng phần tử của mảng:");
            }
        }
    }
    public static int[] enterElementArray(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập phần tử của mảng:");
            while(input.hasNextLine()) {
                String elementArray = input.nextLine();
                if (checkElementArray(elementArray)) {
                    array[i] = Integer.parseInt(elementArray);
                    break;
                } else {
                    System.out.println("Nhập không đúng kiểu dữ liệu phần tử của mảng");
                    System.out.println("Nhập phần tử của mảng:");
                }
            }
        }
        System.out.println("Mảng trước khi sắp xếp");
        return array;
    }
    public static int[] sortedElementArray(int[] array) {
        int[] sortedArray = new int[array.length];
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        sortedArray = Arrays.copyOf(array, n);
        System.out.println("Mảng sau khi sắp xếp");
        return sortedArray;
    }
    public static void displayElementArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static boolean checkElementArray(String elementArray) {
        String regex = "^\\d{1,}|\\-\\d{1,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(elementArray);
        return matcher.matches();
    }
}