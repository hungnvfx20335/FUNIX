import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String enterString = enterString().toLowerCase();
        HashMap<String, Integer> listWord = countWord(enterString);
        System.out.println("Số lượng chữ cái:");
        for (Map.Entry<String, Integer> entry : listWord.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        HashMap<Character, Integer> listCharacter = countCharacter(enterString);
        System.out.println("Số lượng từ:");
        for (Map.Entry<Character, Integer> entry : listCharacter.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
    public static String enterString() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi chủa bạn:");
        return input.nextLine();
    }
    public static HashMap<String, Integer> countWord(String input) {
        String[] arrayOfString = input.split(" ");
        HashMap<String, Integer> listWord = new HashMap<>();
        int count = 0;
        for (String s : arrayOfString) {
            listWord.put(s, count);
        }
        for (Map.Entry<String, Integer> entry : listWord.entrySet()) {
            count = 0;
            for (String s : arrayOfString) {
                if (entry.getKey().equals(s)) {
                    count++;
                }
            }
            listWord.put(entry.getKey(), count);
        }
        return listWord;
    }
    public static HashMap<Character, Integer> countCharacter(String input) {
        String checkedInput = input.trim();
        checkedInput = input.replaceAll(" ", "");
        String[] arrayOfCharacter = checkedInput.split("");
        HashMap<Character, Integer> listCharacter = new HashMap<>();
        int count = 0;
        for (String s : arrayOfCharacter) {
            listCharacter.put(s.charAt(0), count);
        }
        for (Map.Entry<Character, Integer> entry : listCharacter.entrySet()) {
            count = 0;
            for (String s : arrayOfCharacter) {
                if (String.valueOf(entry.getKey()).equals(s)) {
                    count++;
                }
            }
            listCharacter.put(entry.getKey(), count);
        }
        return listCharacter;
    }
}