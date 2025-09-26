# Lab 3 — TDD Kata (Warm-up + Bank)

## Background
Practice the **Red–Green–Refactor** cycle. Start RED with a tiny warm-up, then move to the main Bank Account kata.

## Structure
- **Step 0 – Warm-up (RED first):** `example.StringCalculatorTest` is provided and **fails** because `example.StringCalculator` is only a stub.
- **Step 1 – Bank Account Kata:** Implement `lab3.BankAccount` by writing tests first. The class exists with method signatures but methods throw `UnsupportedOperationException` so your tests will start RED.

## Bank Account requirements
- Start balance = 0.
- `deposit(amount)` rejects negative amounts; otherwise increases balance.
- `withdraw(amount)` throws `InsufficientFundsException` if amount > balance; rejects negative amounts.
- `getBalance()` returns current balance.
- All balances are integers.

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
This runs a helper (`tools.SurefireTablePrinter`) bound to the `verify` phase that prints a summary by reading `target/surefire-reports`.

---

## CLI Demo (works after you implement BankAccount)
```bash
mvn -q -DskipTests compile
java -cp target/classes lab3.Main D 100 W 30 BAL
```

---

## Example TDD snippet
```java
account.deposit(100);
account.withdraw(30);
assertEquals(70, account.getBalance());
```
