import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> lambadaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };
        System.out.println(lambadaFunction.apply("1234567890"));
    }
}