# JMH Playground

TODO Add:
* how run tests
* install etc.

Welcome to the JMH Playground! This repository serves as an experimental ground for evaluating the performance and
memory consumption of Java code using JMH (Java Microbenchmark Harness).

# What is JMH?

JMH is a Java harness for building, running, and analyzing nano/micro/milli/macro benchmarks written in Java and other languages
targeting the JVM. It is maintained by the OpenJDK project.

# Getting Started

To start benchmarking your Java code, follow these steps:

* Clone the Repository: Clone this repository to your local machine using the following command:

```
git clone https://github.com/oURMIo/jmh-playground.git
```

* Add Your Code: Inside the src/main/java directory, you'll find the package structure set up for your benchmarks. Add your Java
  classes
  containing the methods you want to benchmark under this directory.

* Write Benchmarks: Write benchmarks using JMH annotations. Refer to the JMH documentation for guidance on how to write benchmarks
  effectively.

* Run the method: ``com.home.jmhspace.BenchmarkRunner.main``

# Results to file

If you want to write the results to a file, use the JVM option ``-rf <type> -rff <filename>``

Example:

```
-rf json -rff results.json
```

Available formats: text, csv, scsv, json, latex

# Acknowledgments

* Thanks to the OpenJDK project for developing and maintaining JMH.

Happy benchmarking! 🚀
