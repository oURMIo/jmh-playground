package com.home.jmhspace.sort;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class QuickSortBM {

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    @Fork(value = 2)
//    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
//    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void quickSortBM() {
        int[] array = {76, 22, 10, 64, 89, 54, 2, 43};

        doQuickSort(array, 0, array.length - 1);
    }

    private static void doQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            doQuickSort(arr, low, pivotIndex - 1);
            doQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
