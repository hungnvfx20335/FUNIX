
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
                sortedElementArray(array, 0, Integer.parseInt(numberElementArray) - 1);
                System.out.println("Mảng sau khi sắp xếp");
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
    public static void sortedElementArray(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            sortedElementArray(array, low, pi - 1);
            sortedElementArray(array, pi + 1, high);
        }
    }
    public static int partition(int[] array, int low, int high) {
        int i = low - 1;
        int pivot = array[high];
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void displayElementArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static boolean checkElementArray(String elementArray) {
        String regex = "^\\d+|-\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(elementArray);
        return matcher.matches();
    }
}