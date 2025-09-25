# Lab 1 — JUnit 5 Basics — Solutions

This project contains the **solution tests** for `example.TextUtils`.

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
A tiny CLI is included to exercise the utilities from the shell.

Build and run:
```bash
mvn -q -DskipTests compile
java -cp target/classes example.Main 'Hello world' 'A man, a plan, a canal: Panama'
```
