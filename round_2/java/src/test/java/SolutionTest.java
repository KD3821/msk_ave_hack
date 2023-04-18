import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "Regular string, a4bc2d5e, aaaabccddddde",
            "Only letters, abcd, abcd",
            "Only digits, 45, ''",
            "Only spaces, '   ', '   '",
            "Digit at start, 3abc, ''",
            "Two digits in a row, aaa10b, ''",
            "Zero after letter, aaa0b, aab",
            "Empty string, '', ''",
            "Digit after slash, qwe\\4\\5, qwe45",
            "Two digits after slash, qwe\\45, qwe44444",
            "Digit after double slash, qwe\\\\5, qwe\\\\\\\\\\",
            "Digit after slash at start, \\33, 333",
            "Line break, d\\n5abc, d\\n\\n\\n\\n\\nabc",
            "Tab, \\t3, \\t\\t\\t",
            "Single quote, \\'2, \\'\\'",
            "Double quote, \\\"2, \\\"\\\"",
            "Alert, \\a3, \\a\\a\\a",
            "Only slash, \\, ''"
    })
    public void expandString(String testName, String string, String expected) {
        String actual = Solution.expandString(string);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Regular string, a4bc2d5e, aaaabccddddde",
            "Only letters, abcd, abcd",
            "Only digits, 45, ''",
            "Only spaces, '   ', '   '",
            "Digit at start, 3abc, ''",
            "Two digits in a row, aaa10b, ''",
            "Zero after letter, aaa0b, aab",
            "Empty string, '', ''",
            "Digit after slash, qwe\\4\\5, qwe45",
            "Two digits after slash, qwe\\45, qwe44444",
            "Digit after double slash, qwe\\\\5, qwe\\\\\\\\\\",
            "Digit after slash at start, \\33, 333",
            "Only slash, \\, ''"
    })
    public void expandStringByStream(String testName, String string, String expected) {
        String actual = Solution.expandStringByStream(string);
        assertEquals(expected, actual);
    }

}