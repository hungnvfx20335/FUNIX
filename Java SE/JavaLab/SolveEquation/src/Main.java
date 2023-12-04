import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String AUTHOR = "NGUYEN VAN HUNG";
    public static final String VERSION = "@V4.0.0";
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displaySoftwareInformation();
            String select = scanner.nextLine();
            switch(select) {
                case "1" -> calculateSuperlativeEquation();
                case "2" -> calculateQuadraticEquation();
                case "3" -> System.exit(0);
            }
        }
    }
    public static void displaySoftwareInformation()
    {
        System.out.println("+--------------------+-----------------------------------+--------------------+");
        System.out.println("| " + "NGAN HANG SO" + " | " + AUTHOR + VERSION + "                                       |");
        System.out.println("+--------------------+-----------------------------------+--------------------+");
        System.out.println("| 1. Calculate Superlative Equation                                           |");
        System.out.println("| 2. Calculate Quadratic Equation                                             |");
        System.out.println("| 3. Exit                                                                     |");
        System.out.println("+--------------------+-----------------------------------+--------------------+");
        System.out.print("Chọn chức năng: ");
    }
    public static ArrayList<Float> calculateSuperlativeEquation(float a, float b) {
        ArrayList<Float> listSolution = new ArrayList<>();
        listSolution.add(b / a);
        return listSolution;
    }
    public static ArrayList<Float> calculateQuadraticEquation(float a, float b, float c) {
        ArrayList<Float> listSolution = new ArrayList<>();
        return listSolution;
    }
    public static void calculateSuperlativeEquation() {
        while (true) {
            System.out.print("Enter A: ");
            String a = scanner.nextLine();
            if (validateNumber(a)) {
                while (true) {
                    System.out.print("Enter B: ");
                    String b = scanner.nextLine();
                    if (validateNumber(b)) {
                        ArrayList<Float> listSolution = calculateSuperlativeEquation(Float.parseFloat(a), Float.parseFloat(b));
                        System.out.print("Solution: ");
                        listSolution.forEach(aFloat -> System.out.println("x = " + aFloat));
                        String odd = "";
                        String even = "";
                        String perfectSquare = "";

                        if (isOdd(Float.parseFloat(a))) {
                            odd = a + " ";
                        } else {
                            even = a + " ";
                        }
                        if (isOdd(Float.parseFloat(b))) {
                            odd = b + " ";
                        } else {
                            even = b + " ";
                        }
                        if (isPerfectSquare(Float.parseFloat(a))) {
                            perfectSquare = a + " ";
                        }
                        if (isPerfectSquare(Float.parseFloat(b))) {
                            perfectSquare = b + " ";
                        }
                        System.out.println("Number is odd: " + odd);
                        System.out.println("Number is even: " + even);
                        System.out.println("Number is Perfect Square: " + perfectSquare);
                        break;
                    }
                }
                break;
            }
        }
    }
    public static void calculateQuadraticEquation() {

    }
    public static boolean validateNumber(String number) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public static boolean isOdd(float number) {
        return number % 2 != 0;
    }
    public static boolean isPerfectSquare(float number) {
        float x = (float) Math.sqrt(number);
        x = Math.round(x);
        return Math.pow(x, 2) == number;
    }
}