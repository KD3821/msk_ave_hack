import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "Regular string, a2b3, aabbb",
            "Symbol with no digits, yu7o9k3Ж9m4, yuuuuuuuoooooooookkkЖЖЖЖЖЖЖЖЖmmmm",
            "String starts with digit, 2a2, aa",
            "Two digits in a row, a10b, aaaaaaaaaab",
            "Null as digit, a0b3, abbb",
            "One as digit, a1b3, abbb",
            "Empty string, '', ''",
            "String ends on symbol, a2b, aab",
            "Symbols with space, a  b, a  b",
            "Only digits, 13, ''",
            "One symbol, a, a",
            "One digit, 3, ''",
            "Space with digit, ' 3', '   '",
            "Only spaces, '   ', '   '"
    })
    public void shouldExpandString(String testName, String string, String expected) {
        String actual = Solution.expandString(string);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Regular string, a2b3, aabbb",
            "Symbol with no digits, yu7o9k3Ж9m4, yuuuuuuuoooooooookkkЖЖЖЖЖЖЖЖЖmmmm",
            "String starts with digit, 2a2, aa",
            "Two digits in a row, a10b, aaaaaaaaaab",
            "Null as digit, a0b3, abbb",
            "One as digit, a1b3, abbb",
            "Empty string, '', ''",
            "String ends on symbol, a2b, aab",
            "Symbols with space, a  b, a  b",
            "Only digits, 13, ''",
            "One symbol, a, a",
            "One digit, 3, ''",
            "Space with digit, ' 3', '   '",
            "Only spaces, '   ', '   '"
    })
    public void shouldExpandStringByStream(String testName, String string, String expected) {
        String actual = Solution.expandStringByStream(string);
        assertEquals(expected, actual);
    }

}