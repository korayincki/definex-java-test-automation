# Lab 1 — JUnit 5 Basics

## Background
The `TextUtils` class provides **string utility methods**: counting words and checking palindromes.  
Although simple, string manipulation often hides tricky corner cases (nulls, whitespace, punctuation, case sensitivity).  

Such utility methods are common in enterprise code, and a good place to build strong foundations in writing tests.  

## How a Successful Implementation Should Work
- `"Hello world"` → `countWords` returns `2`.  
- `null` or empty string → `countWords` returns `0`.  
- `"A man, a plan, a canal: Panama"` → `isPalindrome` returns `true`.  
- `"Not a palindrome"` → `isPalindrome` returns `false`.  

## Goal
Practice clean test anatomy and assertions.  

## Steps
1. Create `TextUtilsTest`.  
2. Test `countWords` with null, empty, whitespace-only, and normal sentences.  
3. Test `isPalindrome` with true and false cases.  
4. Run `mvn test` and open coverage.  

## Expected Results
- All tests green.  
- Coverage >90%.  

## Extensions
- Convert palindrome test into parameterized form with `@CsvSource`.  

---

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
java -cp target/classes example.Main "Hello world" "A man, a plan, a canal: Panama"
```

Sample output:
```
Input: Hello world
  countWords = 2
  isPalindrome = false

Input: A man, a plan, a canal: Panama
  countWords = 7
  isPalindrome = true
```
