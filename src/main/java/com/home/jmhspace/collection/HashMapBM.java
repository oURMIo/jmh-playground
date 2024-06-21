package com.home.jmhspace.collection;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2)
@Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class HashMapBM {

    @Param({"100", "1000", "10000"})
    private int n;

    private HashMap<Integer, String> hashMap = new HashMap<>();

    public HashMapBM() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int key = rand.nextInt();
            String value = "value_" + i;
            hashMap.put(key, value);
        }
    }

    @Benchmark
    public String insertAndGet() {
        int key = new Random().nextInt();
        String value = "test";
        hashMap.put(key, value);
        return hashMap.get(key);
    }

    @Benchmark
    public boolean insertAndRemove() {
        int key = new Random().nextInt();
        String value = "test";
        hashMap.put(key, value);
        return hashMap.remove(key) != null;
    }
}