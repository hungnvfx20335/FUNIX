import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        ArrayList<String> firstUpperList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        firstUpperList.sort(String::compareTo);
        firstUpperList.forEach(System.out::println);
    }
}