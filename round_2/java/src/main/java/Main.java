import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Main {
    private static final String error = "%s – это некорректная строка\n";
    private static final ArrayList<String> escapeSequences = new ArrayList<>(Arrays.asList(
            "a", "b", "t", "n", "f", "r", "v", "'", "\""));

    public static void main(String[] args) {

    }

    public static String expandString(String str) {
        if (str.trim().isEmpty()) return str;

        String error = "%s – это некорректная строка\n";
        ArrayList<String> escapeSequences = new ArrayList<>(Arrays.asList(
                "a", "b", "t", "n", "f", "r", "v", "'", "\""));

        StringBuilder result = new StringBuilder();
        String charToPrint = "";
        int repeats = 1;
        boolean escapeFlag = false;
        boolean digitFlag = false;

        for (int i = 0; i < str.length(); i++) {
            // проверяем, является ли символ строки цифрой, кроме случая экранированной цифры
            if (!escapeFlag && Character.isDigit(str.charAt(i))) {
                // если это цифра в начале строки или идущая подряд
                if (i == 0 || digitFlag) {
                    System.out.printf(error, str);
                    return "";
                }
                // иначе запоминаем цифру в качестве числа повторений
                repeats = Integer.parseInt(String.valueOf(str.charAt(i)));
                digitFlag = true;
            } else {
                // добавляем в строку-результат символ для записи, повторенный заданное число повторений
                result.append(charToPrint.repeat(repeats));
                repeats = 1;

                String currentChar = String.valueOf(str.charAt(i));
                // если предыдущий символ был слэш, то проверяем текущий символ на escape-последовательность
                if (escapeFlag && escapeSequences.contains(currentChar)) {
                    charToPrint = "\\" + currentChar;
                    escapeFlag = false;
                } // затем проверяем является ли текущий символ экранирующим слэшем
                else if (!escapeFlag && "\\".equals(currentChar)) {
                    charToPrint = "";
                    escapeFlag = true;
                } else {
                    charToPrint = currentChar;
                    escapeFlag = false;
                }
                digitFlag = false;
            }
        } // дописываем в результат последний символ для записи
        result.append(charToPrint.repeat(repeats));
        return result.toString();
    }

    public static String expandStringByStream(String str) {
        if (str.matches("(^\\d.*)|([^\\\\]*\\d{2,}.*)")) {      // если есть цифра в начале строки или две подряд
            System.out.printf(error, str);
            return "";
        }
        return Pattern.compile("(\\\\.|\\D)\\d?")
                .matcher(str).results().map(MatchResult::group) // получаем поток из вхождений в виде строк
                .map(s -> s.replaceFirst("\\\\", ""))           // убираем экранирующие слэши
                .map(s -> s.length() < 2 ? s :                  // если символ записан без цифры, то просто берем его
                        s.substring(0, 1).repeat(Integer.parseInt(s.substring(1)))) // иначе повторяем символ
                .collect(Collectors.joining(""));               // собираем в строку-результат
    }
}