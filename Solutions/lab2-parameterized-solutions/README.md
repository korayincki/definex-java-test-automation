# Lab 2 — Data-Driven Tests — Solutions

This project contains the **solution tests** for `lab2.TaxCalculator` using JUnit 5 `@ParameterizedTest` with CSV sources.

## How to run tests
```bash
mvn -q test
```

Open coverage after a run:
```
target/site/jacoco/index.html
```

### Console Result Table (Surefire)
To print a summary table of test results in the console after tests:
```bash
mvn -q verify
```
This runs a small helper (`tools.SurefireTablePrinter`) bound to the `verify` phase via the `exec-maven-plugin` and prints a neat ASCII table by reading Surefire XMLs under `target/surefire-reports`.

---

## CLI Demo
A tiny CLI is included to exercise the calculator from the shell.

Build and run:
```bash
mvn -q -DskipTests compile
java -cp target/classes lab2.Main 5000 20 10000 35
```
