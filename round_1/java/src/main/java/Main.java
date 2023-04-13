
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    public static String expandString(String str) {
        if (str.trim().isEmpty()) return str;

        StringBuilder result = new StringBuilder();
        StringBuilder digitsString = new StringBuilder();
        String charToRepeat = "";

        for (int i = 0; i <= str.length(); i++) {
            String currentChar = "";
            if (i < str.length()) {
                currentChar = String.valueOf(str.charAt(i));
            }
            try {                                   // если символ является цифрой
                digitsString.append(Integer.parseInt(currentChar));
            } catch (NumberFormatException nfe) {   // если символ не является цифрой
                int repeats = 1;
                // если строка с цифрами не пустая и не состоит из нулей
                if (!digitsString.toString().replace("0", "").isEmpty()) {
                    repeats = Integer.parseInt(digitsString.toString());
                }
                // добавляем к строке-результату символ для записи, повторенный указанное число раз
                result.append(charToRepeat.repeat(repeats));
                charToRepeat = currentChar;
                digitsString.setLength(0);
            }
        }
        return result.toString();
    }

    public static String expandStringByStream(String str) {
        return Pattern.compile("\\D\\d*")
                .matcher(str).results().map(MatchResult::group)       // поток из вхождений в виде строк
                .map(s -> s.length() < 2 ? s :                        // если во вхождении только символ, то берем его
                        s.substring(0, 1).repeat(                     // иначе повторяем символ
                                Math.max(Integer.parseInt(s.substring(1)), 1))) // заданное число раз или 1
                .collect(Collectors.joining(""));                     // собираем в строку-результат
    }
}