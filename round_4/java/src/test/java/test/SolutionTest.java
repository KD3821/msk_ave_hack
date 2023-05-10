package test;

import code.Solution;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "Regular string, aaaaYniuiiiipopo, a4Yniui4popo",
            "Escape chars, \\4\\5aaaa\\\\bbbb, 45a4\\b4",
            "Digit, r45tfg, ''",
            "Beginning on digit, 45 tfg, ''",
            "Ending on digit, abc4, ''",
            "Empty string, '', ''",
            "Spaces, '   ', '   '",
            "Ending by slash, \\aa\\, a2",
            "Two slashes, \\\\\\\\, \\2"
    })
    public void expandString(String testName, String string, String expected) {
        String actual = Solution.compressString(string);
        assertEquals(expected, actual);
    }
}