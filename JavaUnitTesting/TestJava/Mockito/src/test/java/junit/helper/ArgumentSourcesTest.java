package junit.helper;

import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ArgumentSourcesTest extends StringHelper {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        Assertions.assertTrue(ArgumentSources.isBlank(input));
    }
    @ParameterizedTest
    @NullAndEmptySource
    public void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        Assertions.assertTrue(ArgumentSources.isBlank(input));
    }
    @ParameterizedTest
    @EnumSource (
            value = Month.class,
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = EnumSource.Mode.EXCLUDE
    )
    public void exceptFourMonths_OthersAre31DaysLong(Month month) {
        final boolean isALeapYear = false;
        Assertions.assertEquals(31, month.length(isALeapYear));
    }
    @ParameterizedTest
    @CsvFileSource( resources = "/data.csv", numLinesToSkip = 1)
    public void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(String input, String expected) {
        String actualValue = input.toUpperCase();
        Assertions.assertEquals(expected, actualValue);
    }
    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        Assertions.assertEquals(expected, ArgumentSources.isBlank(input));
    }
    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(null, true), // null strings should be considered blank
            Arguments.of("", true),
            Arguments.of("  ", true),
            Arguments.of("not blank", false)
    );

    /*@ParameterizedTest
    @VariableSource("arguments")
    void isBlank_ShouldReturnTrueForNullOrBlankStringsVariableSource(
            String input, boolean expected) {
        Assertions.assertEquals(expected, ArgumentSources.isBlank(input));
    }*/
}