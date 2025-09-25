# Lab 2 — Data-Driven Tests (JUnit @ParameterizedTest + CSV)

## Background
This lab covers **parameterized testing** using CSV data sources with JUnit 5 `@ParameterizedTest`.

The application is a **Tax Calculator** that computes *net salary* from *gross salary* based on a tax rate.

## Business Rules
- Tax percentage is an **integer** between **0** and **100** (inclusive).
- Formula: `net = gross - (gross * taxRate / 100)`.
- Negative gross salary or invalid tax percentage should raise an error.

### Examples
- gross = 5000, tax = 20 → net = 4000  
- gross = 10000, tax = 35 → net = 6500

## Goal
Write clean, **CSV-driven parameterized tests** for both happy-path and error cases.

## Steps
1. Open `src/test/java/lab2/TaxCalculatorTest.java`.
2. Implement a `@ParameterizedTest` with `@CsvSource` for valid cases (columns: `gross, tax, expectedNet`).
3. Add another `@ParameterizedTest` (or plain tests) for **error cases** (negative gross, tax < 0, tax > 100).
4. Run tests and view coverage.

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
A helper (`tools.SurefireTablePrinter`) is bound to `verify` via the `exec-maven-plugin` and prints a neat ASCII table from `target/surefire-reports`.

---

## CLI Demo
A tiny CLI is included to exercise the calculator from the shell.

Build and run:
```bash
mvn -q -DskipTests compile
java -cp target/classes lab2.Main 5000 20 10000 35
```

Sample output:
```
Gross=5000 Tax=20% -> Net=4000
Gross=10000 Tax=35% -> Net=6500
```
