public class Main {
    public static void main(String[] args) {

        //System.out.println(3/0); ArithmeticException.
        try {
            System.out.println(3/0);
        } catch (ArithmeticException arithmeticException) {
            System.out.printf("Caught Arithmetic exception = %s\n", arithmeticException);
        }
    }
}