package junit.helper;

public class ArgumentSources {
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
