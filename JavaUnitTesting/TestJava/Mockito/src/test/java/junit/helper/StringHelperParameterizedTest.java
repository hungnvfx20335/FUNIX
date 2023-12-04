package junit.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest extends StringHelper {
    StringHelper stringHelper;

    @Before
    public void setUp() {
        stringHelper = new StringHelper();
    }

    @After
    public void tearDown() {
    }
    private final String input;
    private final String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String[][] expectedOutputs = {
                new String[]{"AACD", "CD"},
                new String[]{"ACD", "CD"}};
        return Arrays.asList(expectedOutputs);
    }

    @org.junit.Test
    public void testTruncateAInFirstPosition() {
        assertEquals(expectedOutput,
                stringHelper.truncateAInFirstPosition(input));
    }
}