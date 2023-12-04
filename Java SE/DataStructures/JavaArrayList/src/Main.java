import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int rowItems = scanner.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < rowItems; j++) {
                arrayList.add(scanner.nextInt());
            }
            lists.add(arrayList);
        }
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ArrayList<Integer> listQueries = lists.get(a - 1);
            if (b > listQueries.size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(listQueries.get(b - 1));
            }
        }
    }
}