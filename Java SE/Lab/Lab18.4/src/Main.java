import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> listName = Arrays.asList(
                "hung",
                "cuong",
                "lan",
                "toan"
        );
        ArrayList<String> firstUpperList = new ArrayList<>();
        listName.forEach(name ->
                firstUpperList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));
        firstUpperList.sort(String::compareTo);
        firstUpperList.forEach(System.out::println);
    }
}