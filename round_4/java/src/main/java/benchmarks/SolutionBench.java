package benchmarks;

import java.util.concurrent.TimeUnit;

import code.Solution;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 200, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SolutionBench {

    @Benchmark
    public void testMethod3(Blackhole bh){
        String array = Solution.compressString("aaaaYniuiiiipopo");
        bh.consume(array);
    }
}