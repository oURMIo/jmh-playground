package com.home.jmhspace;

import org.openjdk.jmh.Main;

public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        String benchmarkClass = "com.home.jmhspace.math.FactorialBM";

        System.out.println("Running benchmark: " + benchmarkClass);

        Main.main(new String[]{benchmarkClass});
    }
}
