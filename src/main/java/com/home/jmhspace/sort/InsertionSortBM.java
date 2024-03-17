package com.home.jmhspace.sort;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class InsertionSortBM {

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @Fork(value = 2)
//    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
//    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void insertionSortBM() {
        int[] array = {76, 22, 10, 64, 89, 54, 2, 43};

        doInsertionSort(array);
    }

    private static void doInsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
