package com.home.jmhspace.sort;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

public class CombSortBM {

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void combSortBM() {
        int[] array = {76, 22, 10, 64, 89, 54, 2, 43};

        doCombSort(array);
    }

    private static void doCombSort(int[] arr) {
        var gap = arr.length;
        var swapped = true;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }

            swapped = false;
            var i = 0;

            while (i + gap < arr.length) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
                i++;
            }
        }
    }
}
