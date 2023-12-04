package junit.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArraysCompareTest extends ArraysCompare {
    ArraysCompare arraysCompare;

    @Before
    public void setUp() throws Exception {
        arraysCompare = new ArraysCompare();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sortArray() {
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};
        arraysCompare.sortArray(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void sortNullArray() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            arraysCompare.sortNullArray();
        });
        String expectedMessage = "null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test(timeout = 1000000)
    public void testSortPerformance() {
        int[] numbers = {8, 9, 12, 2, 19, 7};
        for (int i = 0; i < 1000000000; i++) {
            arraysCompare.sortArray(numbers);
        }
    }
}