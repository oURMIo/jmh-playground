package com.home.jmhspace.sort;

import java.util.Arrays;
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

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
@Warmup(iterations = 5, time = 5000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 5000, timeUnit = TimeUnit.MILLISECONDS)
public class MergeSortBM {

    private int[] array;

    @Setup(Level.Iteration)
    public void setup() {
        array = new int[]{76, 22, 10, 64, 89, 54, 2, 43};
    }

    @Benchmark
    public void mergeSortBM() {
        int[] clone = array.clone();
        doMergeSort(clone);
    }

    public static void doMergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        doMergeSort(left);
        doMergeSort(right);

        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
