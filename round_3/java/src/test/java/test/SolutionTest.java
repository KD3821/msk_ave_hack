package test;

import code.Solution;
import code.SolutionReview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;

public class SolutionTest {

    private static final String text;

    static {
        try {
            text = Files.readString(Path.of("src/test/resources/text.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printArrays(String[] actual, String[] expected) {
        System.out.println("Actual:   " + Arrays.toString(actual));
        System.out.println("Expected: " + Arrays.toString(expected) + "\n");
    }

    @Test
    public void findTopWords() {
        String[] actual = Solution.findTop10Words(text);
        String[] expected = {"он", "и", "а", "что", "ты", "не", "если", "-", "то", "Кристофер"};

        printArrays(actual, expected);
        Assertions.assertTrue(Set.of(actual).containsAll(Set.of(expected)));
    }

    @Test
    public void findTopWordsCaseSensitive() {
        String[] actual = Solution.findTop10WordsCaseSensitive(text);
        String[] expected = {"он", "а", "и", "что", "ты", "не", "то", "его", "кристофер", "в"};

        printArrays(actual, expected);
        Assertions.assertTrue(Set.of(actual).containsAll(Set.of(expected)));
    }

    @Test
    public void findTopWordsReview() {
        String[] actual = SolutionReview.findTopWords(text);
        String[] expected = {"а", "он", "и", "ты", "что", "в", "его", "если", "кристофер", "не"};

        printArrays(actual, expected);
        Assertions.assertArrayEquals(actual, expected);
    }

}