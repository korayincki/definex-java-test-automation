# Lab 3 — TDD Kata — Solutions

This project contains the **passing tests** and a clean implementation for:
- Warm-up: `example.StringCalculator`
- Main kata: `lab3.BankAccount`

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
A tiny CLI is included for the bank account.

Build and run:
```bash
mvn -q -DskipTests compile
java -cp target/classes lab3.Main D 100 W 30 BAL
```
