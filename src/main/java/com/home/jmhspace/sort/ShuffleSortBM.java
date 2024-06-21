package com.home.jmhspace.sort;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class ShuffleSortBM {

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void shuffleSortBM() {
        int[] array = {76, 22, 10, 64, 89, 54, 2, 43};

        doShuffleSort(array);
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
