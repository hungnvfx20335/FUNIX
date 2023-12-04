import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void everyNthChar() {
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        Utilities utilities = new Utilities();
        assertEquals("ABCDEF", utilities.removePairs("ABBCDEEF"));
        assertEquals("ABCBDEF", utilities.removePairs("ABCBDEEF"));
    }

    @org.junit.jupiter.api.Test
    void converter() {
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
    }
}