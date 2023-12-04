import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    public void everyNthChar() {
        Utilities utilities = new Utilities();
        char[] output = utilities.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e', 'l'}, output);
        char[] output1 = utilities.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 6);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output1);
    }

    @org.junit.jupiter.api.Test
    void converter() {
        Utilities utilities = new Utilities();
        assertEquals(300, utilities.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        Utilities utilities = new Utilities();
        assertNull(utilities.nullIfOddLength("odd"));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}