# Lab 0 – Discount Calculator (Kick-off)

## Goal
Warm up with a tiny domain: compute a discount for an order value. The aim is to get familiar with the toolchain and **standardize JUnit 5 annotations** from the start.

## App Summary
Input: order value (int).  
Output: discount amount (int).  
Rules (examples; extend/refine during exercises):
- < 100 → 0% discount
- 100–199 → 10% discount
- ≥ 200 → 25% discount
- > 300 -> 30% discount

## Why these JUnit 5 annotations here?
- `@Test` – actual checks.
- `@BeforeEach`/`@AfterEach` – clean state around every test.
- `@BeforeAll`/`@AfterAll` – demonstrate one-time init/teardown.
- `@DisplayName` – human-readable test names in reports.

## How to run
```bash
mvn -q test
```
Open coverage: `target/site/jacoco/index.html`

## Expected (sample) console snippet
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running lab0.Lab0SmokeTest
[INFO] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
```

> Note: Some tests throw `UnsupportedOperationException` by design to keep the exercise hands-on.
