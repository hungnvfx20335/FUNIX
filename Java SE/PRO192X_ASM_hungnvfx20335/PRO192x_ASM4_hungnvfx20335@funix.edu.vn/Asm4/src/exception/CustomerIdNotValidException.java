package exception;

public class CustomerIdNotValidException  extends RuntimeException{
    public CustomerIdNotValidException(String massage) {
        super(massage);
    }
}
