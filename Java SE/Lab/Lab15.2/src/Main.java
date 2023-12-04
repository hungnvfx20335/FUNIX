import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> bobDices = readDices("Bob.txt");
            System.out.println(bobDices);
            List<Integer> aliceDices = readDices("Alice.txt");
            System.out.println(aliceDices);

            String winner = getWinner(bobDices, aliceDices);
            if (winner == null) {
                System.out.println("Two people have equal points");
            } else {
                System.out.println("The winner is " + winner);
            }
        } catch (InvalidDiceException | NumberRollDiceNotEqualException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("The file contains non numeric data");
        }
    }

    public static List<Integer> readDices(String fileName) throws InvalidDiceException, FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> integerList = new ArrayList<>();
        try (Scanner input = new Scanner(bufferedReader)) {
            while (input.hasNext()) {
                int dice = input.nextInt();
                if (dice < 1) {
                    throw new InvalidDiceException("Giá trị dice nhỏ hơn 1");
                } else if (dice > 6) {
                    throw new InvalidDiceException("Giá trị dice lớn hơn 6");
                } else {
                    integerList.add(dice);
                }
            }

        }
        return integerList;
    }

    public static Integer sumOfDice(List<Integer> dices) {
        Integer answer = 0;
        for (Integer integer : dices) {
            answer += integer;
        }
        return answer;
    }

    public static String getWinner(List<Integer> bobDices, List<Integer> aliceDices) {
        if (bobDices.size() != aliceDices.size()) {
            throw new NumberRollDiceNotEqualException("Number of dice roll not equal");
        }
        if (sumOfDice(bobDices) > sumOfDice(aliceDices)) {
            return "Bod";
        } else if (sumOfDice(bobDices) < sumOfDice(aliceDices)){
            return "Alice";
        }
        return null;
    }
}