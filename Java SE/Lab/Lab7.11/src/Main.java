import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập dữ liệu cho mảng!");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = getIntegers(n);
        arr = sortArray(arr);
        printArray(arr);
    }
    public static int[] getIntegers(int capacity) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = input.nextInt();
        }
        return arr;
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] sortArray(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] < sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }
}