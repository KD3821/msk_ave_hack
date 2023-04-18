package code;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

public class Solution {

    public static void main(String[] args) {

    }

    public static String[] findTopWords(String str, int numberOfWords, boolean caseSensitive) {
        String[] words = caseSensitive ?
                str.toLowerCase().split("[^а-яa-z\\-]+(-)?") :
                str.split("\\s+");

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