import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void printLargestElement() {
        int[] arr = {2, 3, 5, 7};
        int largest = Main.printLargestElement(arr);
        assertEquals(7, largest);
    }
}