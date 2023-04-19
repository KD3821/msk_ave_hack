package code;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

public class Solution {

    private static final String EMPTY = "Данная строка не содержит слов.";

    public static String[] findTop10Words(String str) {
        if (str == null || str.isBlank()) {
            System.out.println(EMPTY);
            return new String[]{};
        }

        String[] words = str.split("\\s+");

        return findTopWordsInArray(words, 10);
    }

    public static String[] findTop10WordsCaseSensitive(String str) {
        if (str == null || str.isBlank()) {
            System.out.println(EMPTY);
            return new String[]{};
        }

        String[] words = str.toLowerCase().split("[^а-яa-z\\-]+(-)?");

        return findTopWordsInArray(words, 10);
    }

    private static String[] findTopWordsInArray(String[] words, int numberOfWords) {
        return Arrays.stream(words)
                .filter(w -> !w.isBlank())
                .collect(Collectors.groupingBy(w -> w, reducing(0, w -> 1, Integer::sum)))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .limit(numberOfWords)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

}