package code;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionReview {

    private static final String DASH = "-";
    private static final String PUNCTUATION = "[.,!?:;()]";

    public static void main(String[] args) {

    }

    public static String[] findTopWords(String str) {
        String[] words = str.split("\\s+");

        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            word = word.replaceAll(PUNCTUATION, "");
            if (word.equals(DASH)) {
                continue;
            }
            wordsMap.merge(word.toLowerCase(), 1, Integer::sum);
        }

        ArrayList<WordCount> wordCounts = new ArrayList<>(wordsMap.size());
        for (var word : wordsMap.entrySet()) {
            wordCounts.add(new WordCount(word.getKey(), word.getValue()));
        }

        wordCounts.sort(WordCount::compareTo);

        String[] result = new String[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = wordCounts.get(i).word;
        }

        return result;
    }

    private static class WordCount implements Comparable<WordCount> {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount wc) {
            if (this.count == wc.count) {
                return this.word.compareTo(wc.word);
            }
            return wc.count - this.count;
        }
    }
}