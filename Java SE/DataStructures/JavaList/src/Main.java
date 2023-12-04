import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int m = input.nextInt();
        for (int i = 0; i < m; i++) {
            String select = input.next();
            if (select.equals("Insert")) {
                int a = input.nextInt();
                int b = input.nextInt();
                list.add(a, b);
            } else if (select.equals("Delete")){
                int a = input.nextInt();
                list.remove(a);
            }
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}