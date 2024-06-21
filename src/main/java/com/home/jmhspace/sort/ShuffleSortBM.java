package com.home.jmhspace.sort;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class ShuffleSortBM {

    private int[] array;

    @Setup(Level.Iteration)
    public void setup() {
        array = new int[]{76, 22, 10, 64, 89, 54, 2, 43};
    }

    @Benchmark
    public void shuffleSortBM(Blackhole bh) {
        int[] clone = array.clone();
        doShuffleSort(clone);
        bh.consume(clone);
    }

    private static void doShuffleSort(int[] arr) {
        Random random = new Random();
        boolean isSorted = false;

        while (!isSorted) {
            for (int i = 0; i < arr.length; i++) {
                int randomIndex = random.nextInt(arr.length);
                swap(arr, i, randomIndex);
            }

            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    break;
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
