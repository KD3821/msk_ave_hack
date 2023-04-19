package benchmarks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import code.Solution;
import code.SolutionReview;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 200, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SolutionBench {

    private static final String text;

    static {
        try {
            text = Files.readString(Path.of("src/test/resources/text.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public void testMethod1(Blackhole bh){
        String[] array = Solution.findTop10Words(text);
        bh.consume(array);
    }

    @Benchmark
    public void testMethod2(Blackhole bh){
        String[] array = Solution.findTop10WordsCaseSensitive(text);
        bh.consume(array);
    }

    @Benchmark
    public void testMethod3(Blackhole bh){
        String[] array = SolutionReview.findTopWords(text);
        bh.consume(array);
    }
}