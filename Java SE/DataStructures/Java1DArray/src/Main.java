import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập N phần tử của mảng:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử trong mảng:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        for (Integer integer : array) {
            System.out.println(integer);
        }
    }
}