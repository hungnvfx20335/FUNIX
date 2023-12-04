import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] edgeMatrix;
        while (true) {
            System.out.println("Nhập số nút của đồ thị:");
            String numberNodes = input.nextLine();
            if (checkInputNumber(numberNodes)) {
                edgeMatrix = new int[Integer.parseInt(numberNodes)][Integer.parseInt(numberNodes)];
                edgeMatrix = enterEdgeMatrix(Integer.parseInt(numberNodes));
                break;
            }
        }
        int startPoint = enterStartPoint() - 1;
        int endPoint = enterEndPoint() - 1;
        if (undirectedGraph(edgeMatrix, startPoint, endPoint)) {
            System.out.println("This is an edge");
        } else {
            System.out.println("This is not an edge");
        }

    }
    public static boolean undirectedGraph(int[][] edgeMatrix, int startPoint, int endPoint) {
        for (int i = 0; i < edgeMatrix.length; i++) {
            for (int j = 0; j < edgeMatrix.length; j++) {
                if (i == startPoint && j == endPoint) {
                    if (edgeMatrix[i][j] == 1) {
                        return true;
                    }
                }
                if (i == endPoint && j == startPoint) {
                    if (edgeMatrix[i][j] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int[][] enterEdgeMatrix(int number) {
        int[][] matrix = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.println("Nhập phần tử hàng thứ " + (i + 1) + " cột thứ " + (j + 1));
                while (true) {
                    String elementMatrix = input.nextLine();
                    if (checkInputNumber(elementMatrix)) {
                        matrix[i][j] = Integer.parseInt(elementMatrix);
                        break;
                    }

                }
            }
        }
        return matrix;
    }
    public static int enterStartPoint() {
        int answer = 0;
        while (true) {
            System.out.println("Nhập điểm bắt đầu");
            String startPoint = input.nextLine();
            if (checkInputNumber(startPoint)) {
                answer = Integer.parseInt(startPoint);
                break;
            }
        }
        return answer;
    }
    public static int enterEndPoint() {
        int answer = 0;
        while (true) {
            System.out.println("Nhập điểm kết thúc");
            String endPoint = input.nextLine();
            if (checkInputNumber(endPoint)) {
                answer = Integer.parseInt(endPoint);
                break;
            }
        }
        return answer;
    }
    public static boolean checkInputNumber(String question) {
        String regex = "^\\d$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(question);
        return matcher.matches();
    }
 }