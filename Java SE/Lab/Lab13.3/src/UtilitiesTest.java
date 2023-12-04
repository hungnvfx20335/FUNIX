import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class UtilitiesTest {
    public Utilities utilities;
    @org.junit.Before
    public void setup() {
        utilities = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
    }

    @org.junit.jupiter.api.Test
    public void converter() throws Exception {
        assertEquals(300, utilities.converter(10, 5));
    }
    @org.junit.Test(expected=ArithmeticException.class)
    public void converterArithmeticException() throws Exception {
        utilities.converter(10, 0);
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
    }
}