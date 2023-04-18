package test;

import code.Solution;
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
        String[] actual = Solution.findTopWords(text, 10, false);
        String[] expected = {"он", "и", "а", "что", "ты", "не", "если", "-", "то", "Кристофер"};

        printArrays(actual, expected);
        Assertions.assertTrue(Set.of(actual).containsAll(Set.of(expected)));
    }

    @Test
    public void findTopWordsCaseSensitive() {
        String[] actual = Solution.findTopWords(text, 12, true);
        String[] expected = {"он", "а", "и", "что", "ты", "не", "если", "то", "его", "кристофер", "робин", "в"};

        printArrays(actual, expected);
        Assertions.assertTrue(Set.of(actual).containsAll(Set.of(expected)));
    }

}