# JMH Playground

JMH Playground is a project designed for benchmarking various algorithms and code snippets.
It utilizes Java 17 and above and is built using Gradle for easy dependency management and build automation.

## What is JMH?

JMH is a Java harness for building, running, and analyzing nano/micro/milli/macro benchmarks written in Java and other languages
targeting the JVM. It is maintained by the OpenJDK project.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

* Java Development Kit (JDK) version 17 or higher
* Gradle version 6 or higher

### Building the Project

1. Clone the repository

```shell
git clone https://github.com/oURMIo/jmh-playground.git
cd jmh-playground
```

2. Build the project

Use Gradle to build the project:

```shell
./gradlew clean build 
```

3. Run Benchmark

```shell
java -jar build/libs/jmh-playground-1.0-SNAPSHOT-all.jar $ClassName
```

## Results to file

If you want to write the results to a file, use the JVM option ``-rf <type> -rff <filename>``

Example:

```
-rf json -rff results.json
```

Available formats: text, csv, scsv, json, latex

Happy benchmarking! 🚀
