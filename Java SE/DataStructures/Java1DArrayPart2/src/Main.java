import java.util.Scanner;

public class Main {

    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0);
    }

    private static boolean canWin(int leap, int[] game, int i) {
        game[i] = 1;
        if (i + 1 >= game.length || i + leap >= game.length) {
            return true;
        } else if (game[i + 1] == 1 &&
                game[i + leap] == 1 &&
                (i > 0 && game[i - 1] == 1)) {
            return false;
        } else {
            return (game[i + 1] == 0 && canWin(leap, game, i + 1)) ||
                    (game[i + leap] == 0 && canWin(leap, game, i + leap)) ||
                    (i > 0 && game[i - 1] == 0 && canWin(leap, game, i - 1));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}