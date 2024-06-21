package com.home.jmhspace.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
public class HashMapSecondBM {

    @Param({"100", "1000", "10000"})
    private int n;

    private final Map<Key, String> hashMap = new HashMap<>();

    public HashMapSecondBM() {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            if (random.nextBoolean()) {
                Key key = new Key(random.nextInt());
                String value = "value_" + i;
                hashMap.put(key, value);
            } else {
                KeySubclass key = new KeySubclass(random.nextInt(), "sub");
                String value = "sub_value_" + i;
                hashMap.put(key, value);
            }
        }
    }

    @Benchmark
    public String insertAndGet() {
        Random random = new Random();
        Key key;
        if (random.nextBoolean()) {
            key = new Key(random.nextInt());
        } else {
            key = new KeySubclass(random.nextInt(), "sub");
        }
        String value = "test";
        hashMap.put(key, value);
        return hashMap.get(key);
    }

    @Benchmark
    public boolean insertAndRemove() {
        Random random = new Random();
        Key key;
        if (random.nextBoolean()) {
            key = new Key(random.nextInt());
        } else {
            key = new KeySubclass(random.nextInt(), "sub");
        }
        String value = "test";
        hashMap.put(key, value);
        return hashMap.remove(key) != null;
    }

    public static class Key {
        private final int id;

        public Key(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Key key = (Key) o;
            return id == key.id;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }
    }

    public static class KeySubclass extends Key {
        private final String type;

        public KeySubclass(int id, String type) {
            super(id);
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            if (!super.equals(o)) {
                return false;
            }
            KeySubclass that = (KeySubclass) o;
            return Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), type);
        }
    }
}