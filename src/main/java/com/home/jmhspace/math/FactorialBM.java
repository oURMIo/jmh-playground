package com.home.jmhspace.math;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
@Warmup(iterations = 3, time = 5000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 5000, timeUnit = TimeUnit.MILLISECONDS)
public class FactorialBM {

    private static final int FACTORIAL_NUMBER = 10;
    private static final int EXPECTED_RESULT = 3628800;

    @Benchmark
    public void benchmarkFactorial() {
        int result = calculateFactorial();
        if (result != EXPECTED_RESULT) {
            throw new AssertionError("Factorial calculation is incorrect!");
        }
    }

    private int calculateFactorial() {
        int result = 1;
        for (int i = 1; i <= FACTORIAL_NUMBER; i++) {
            result *= i;
        }
        return result;
    }
}
