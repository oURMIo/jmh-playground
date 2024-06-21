package com.home.jmhspace.sort;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class SelectionSortBM {

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void selectionSortBM() {
        int[] array = {76, 22, 10, 64, 89, 54, 2, 43};

        doSelectionSort(array);
    }

    private static void doSelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
