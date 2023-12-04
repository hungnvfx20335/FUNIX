import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static final ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử của mảng:");
        String numberArray = null;
        while (input.hasNextLine()) {
            numberArray = input.nextLine();
            if (checkNumberArray(numberArray)) {
                displayArray(enterNumberInteger(Integer.parseInt(numberArray)));
                break;
            } else {
                System.out.println("Nhập không đúng định dạng số.");
                System.out.println("Nhập số lượng phần tử của mảng:");
            }
        }
        System.out.println();
        System.out.println("Mảng sau khi sắp xếp:");
        assert numberArray !=null;
        displayArray(sortArray(arrayList));
    }
    public static ArrayList<Integer> enterNumberInteger(int numberArray) {

        System.out.println("Nhập phần tử của mảng:");
        for (int i = 0; i < numberArray; i++) {
            while (input.hasNextLine()) {
                String enterElement = input.nextLine();
                if (checkNumberArray(enterElement)) {
                    arrayList.add(i, Integer.parseInt(enterElement));
                    break;
                } else {
                    System.out.println("Nhập không đúng định dạng số của phần tử trong mảng");
                    System.out.println("Nhập phần tử của mảng:");
                }
            }
        }

        System.out.println("Mảng trước khi sắp xếp:");
        return arrayList;
    }
    public static ArrayList<Integer> sortArray(ArrayList<Integer> array) {
        ArrayList<Integer> sortedArrayList;
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size() - i; j++) {
                if (array.get(j - 1) > array.get(j)) {
                    int temp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, temp);
                }
            }
        }

        sortedArrayList = (ArrayList<Integer>) array.clone();
        return sortedArrayList;
    }
    public static void displayArray(ArrayList<Integer> array) {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
    }
    public static boolean checkNumberArray(String numberArray) {
        String regex = "^\\d{1,}|\\-\\d{1,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numberArray);
        return matcher.matches();
    }
}