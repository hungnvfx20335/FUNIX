import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> iLoveJava = () -> {return "I Love Java";};
        System.out.println(iLoveJava.get());
    }
}