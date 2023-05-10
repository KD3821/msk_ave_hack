package code;

public class Solution {
    private static final String ERROR = "%s – это некорректная строка\n";
    private static final char ESCAPE_CHAR = '\\';

    public static String compressString(String str) {
        if (str.isBlank()) return str;

        StringBuilder result = new StringBuilder();
        char lastChar = Character.MIN_VALUE;
        boolean escapeFlag = false;
        int repeats = 1;

        for (char currentChar : str.toCharArray()) {
            if (!escapeFlag && Character.isDigit(currentChar)) {
                System.out.printf(ERROR, str);

                return "";
            }

            if (!escapeFlag && currentChar == ESCAPE_CHAR) {
                escapeFlag = true;

                continue;
            }

            escapeFlag = false;

            if (lastChar == currentChar) {
                repeats++;

                continue;
            }

            lastChar = currentChar;

            if (repeats > 1) {
                result.append(repeats);
                repeats = 1;
            }

            result.append(currentChar);
        }

        if (repeats > 1) {
            result.append(repeats);
        }

        return result.toString();
    }
}