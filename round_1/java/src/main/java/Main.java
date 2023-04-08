
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static String expandString(String str) {
        if (str.trim().isEmpty()) return str;       // возвращаем строку, если она пуста или состоит из пробелов

        StringBuilder result = new StringBuilder();
        StringBuilder digitsString = new StringBuilder();
        String charToRepeat = "";
        // проходим по всей длине строки + 1 итерация для записи последнего символа
        for (int i = 0; i <= str.length(); i++) {
            String currentChar = "";                // сначала задаем текущий символ по-умолчанию
            if (i < str.length()) {                 // пока не достигли конца строки
                currentChar = String.valueOf(str.charAt(i)); // берем символ из строки в качестве текущего
            }
            try {                                   // если этот символ является цифрой
                digitsString.append(Integer.parseInt(currentChar)); // дописываем эту цифру в строку с цифрами
            } catch (NumberFormatException nfe) {   // если символ не является цифрой
                int repeats = 1;                    // сначала задаем число повторений символа по-умолчанию
                // если строка с цифрами не пустая и не состоит из нулей
                if (!digitsString.toString().replace("0", "").isEmpty()) {
                    repeats = Integer.parseInt(digitsString.toString()); // задаем число повторений из строки с цифрами
                }
                // добавляем к строке-результату символ для записи, повторенный указанное число раз
                result.append(charToRepeat.repeat(repeats));
                charToRepeat = currentChar;         // запоминаем текущий символ как символ для записи
                digitsString.setLength(0);          // очищаем строку с цифрами
            }
        }
        return result.toString();
    }

    public static String expandStringByStream(String str) {
        Pattern pattern = Pattern.compile("\\D\\d*");

        return pattern.matcher(str).results().map(MatchResult::group) // поток из вхождений в виде строк
                .map(s -> s.length() < 2 ? s :                        // если во вхождении только символ, то берем его
                        s.substring(0, 1).repeat(                     // иначе повторяем символ
                                Math.max(Integer.parseInt(s.substring(1)), 1))) // заданное число раз или 1
                .collect(Collectors.joining(""));             // собираем в строку-результат
    }
}