import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while(true) {
            System.out.println("Nhập số lượng phần tử của mảng:");
            String numberElementArray = input.nextLine();
            if (checkElementArray(numberElementArray)) {
                System.out.println("Nhập phần tử muốn tìm kiếm.");
                String enterSearch = input.nextLine();
                if (checkElementArray(enterSearch)) {
                    int[] array =enterElementArray(Integer.parseInt(numberElementArray));
                    displayElementArray(array);
                    sortedElementArray(array, 0, Integer.parseInt(numberElementArray) - 1);
                    System.out.println("Mảng sau khi sắp xếp");
                    displayElementArray(array);
                    int answer = binarySearch(array, Integer.parseInt(enterSearch));
                    if (answer == -1) {
                        System.out.println("Không tìm thấy phần tử trong mảng");
                    } else {
                        System.out.println("Phần tử muốn tìm kiếm " + enterSearch + " ở vị trí thứ " + answer + " trong mảng");
                    }
                    break;
                } else {
                    System.out.println("Nhập không đúng kiểu dữ liệu số");
                    System.out.println("Mảng sau khi sắp xếp");
                }
                break;
            } else {
                System.out.println("Nhập không đúng kiểu dữ liệu số");
                System.out.println("Nhập số lượng phần tử của mảng:");
            }
        }
    }
    public static int binarySearch(int[] array, int numberSearch) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (array[m] == numberSearch) {
                return m;
            }
            if (array[m] < numberSearch) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return -1;
    }
    public static int[] enterElementArray(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập phần tử của mảng:");
            while(true) {
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
            int m = low + (high - low) / 2;
            sortedElementArray(array, low, m);
            sortedElementArray(array, m + 1, high);
            merge(array, low, m, high);
        }
    }
    public static void merge(int[] array, int low, int m, int high) {
        int n1 = m - low + 1;
        int n2 = high - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(array, low, L, 0, n1);
        for (int j = 0; j < n2; j++) {
            R[j] = array[m + j + 1];
        }
        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            k++;
            i++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
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