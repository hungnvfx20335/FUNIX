package junit.helper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest extends StringHelper {
    StringHelper helper;

    @Before
    public void setUp() {
        helper = new StringHelper();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testTruncateAInFirstPosition() {
        assertEquals("CD", helper.truncateAInFirstPosition("AACD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }
}