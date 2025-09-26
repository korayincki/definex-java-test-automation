# Capstone — Order Pricing Suite (Student Workshop)

**Time:** Day 2 afternoon  
**Theme:** Bring all skills together — *unit testing, parameterized data-driven testing, interaction testing with Mockito, HTTP stubbing with WireMock, coverage discipline*.

---

## Motivation
Real-world pricing logic blends **business rules**, **edge cases**, and **external services** (e.g., FX). This capstone simulates a small yet realistic pricing module where you will **design tests first**, implement behavior, and validate the system with clear coverage goals.

By the end, you’ll have:
- A production-ready `PricingService` that computes final price in **cents**.
- A test suite covering boundaries, invalid inputs, interaction constraints, and HTTP client behavior.
- A repeatable build with coverage and a console summary of test results.

---

## What you will build
`capstone.PricingService.price(Order)` that applies:
- **Discounts**
  - **10%** for **first-time buyers** with **≥ 2 items** (items = sum of quantities).
  - **+700** cents *bulk discount* when **total items > 10**.
  - **Discount cap**: total discounts ≤ **25%** of **subtotal** (sum of line item totals).
- **Shipping**
  - Shipping is **free** when order subtotal ≥ **₺100** (10_000 cents); otherwise **1200** cents.
  - If `order.fragile == true`, add **+500** cents (surcharge).
- **FX (optional)**
  - `CurrencyClient.rate(from, to)` returns a double FX rate. You’ll **stub** it via **WireMock** when writing its tests.

All amounts are **integers (cents)** unless noted. FX rate is a **double**; you decide where to apply it (e.g., converting subtotal to target currency) if you take the extension.

---

## What you will use
- **JUnit 5** (`@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`, `@DisplayName`, `@ParameterizedTest`)
- **Mockito** (`@ExtendWith(MockitoExtension.class)`, `@Mock`, `@InjectMocks`, `verify(...)`, `never()`, `ArgumentCaptor`, `InOrder`)
- **WireMock** for HTTP stubs (200/404/500, faults, malformed body)
- **Maven**, **JaCoCo** coverage, **Surefire table printer**

---

## Learning outcomes
- Turn ambiguous requirements into **concrete tests**.
- Design **boundary-focused** cases and **parameterized** datasets.
- Verify **interactions** (mocking) vs **state** (pure assertions).
- Stub **HTTP** reliably and assert **error mappings**.
- Hit explicit **coverage targets** while keeping tests clean.

---

## Project structure
```
capstone-order-pricing-student/
  ├─ src/
  │  ├─ main/java/capstone/
  │  │   ├─ OrderLine.java
  │  │   ├─ Order.java
  │  │   ├─ PricingService.java        # TODO: implement price(Order)
  │  │   ├─ OrderValidator.java        # used to demo interaction testing
  │  │   ├─ CurrencyClient.java        # simple HTTP client (for WireMock tests)
  │  │   └─ Main.java                  # tiny CLI demo
  │  └─ test/
  │     ├─ java/capstone/
  │     │   ├─ PricingServiceTest.java            # unit tests (skeleton, includes parameterized)
  │     │   ├─ PricingServiceInteractionTest.java # Mockito interaction skeleton
  │     │   └─ CurrencyClientWireMockTest.java    # WireMock skeleton
  │     └─ resources/capstone/thresholds.csv      # sample CSV header for data-driven tests
  ├─ pom.xml
  └─ README.md
```

---

## Step-by-step guide

### 0) Build & sanity check (expect RED)
```bash
mvn -q test
mvn -q verify   # prints Surefire table
```
You will see tests throwing `UnsupportedOperationException` — that’s intentional.

### 1) Design your data model (already scaffolded)
- `OrderLine(sku, quantity, unitPriceCents)`; `quantity > 0`, `unitPriceCents >= 0`.
- `Order` holds `List<OrderLine> lines`, `boolean firstTimeBuyer`, `boolean fragile`.
- Utility methods already provided: `subtotal()` and `totalItems()`.

### 2) Write **unit tests** for `PricingService.price(Order)`
Cover boundaries and invalid inputs:
- Items: **1, 2, 10, 11** (to exercise first-time and bulk rules).
- Totals: **9_999 / 10_000 / 10_001** for shipping free threshold.
- Discount **cap** at **25% of subtotal**.
- Fragile surcharge path.
Use **@ParameterizedTest** with **@CsvSource** or the provided `thresholds.csv`.

### 3) Implement the pricing logic
Replace the `UnsupportedOperationException` in `PricingService.price` with your code. Keep integers in cents; carefully order operations and enforce the **cap**.

### 4) Add **interaction tests** with Mockito
- Introduce `OrderValidator` into `PricingService` (already a constructor dependency).
- Verify `validator.validate(order)` is called **once** on happy path.
- For invalid orders, stub `validator` to throw and assert that downstream calculation **does not run** (`verifyNoMoreInteractions` on collaborators).

### 5) Add **WireMock** tests for `CurrencyClient`
- Test **200** (return numeric string rate) → client returns `double`.
- Test **404/500** → client wraps as `RuntimeException` with cause types.
- Test **faults/malformed** body.
Tip: See `lab6` style; use `WireMockServer` lifecycle and `verify(getRequestedFor(...))`.

### 6) Coverage goals
- **PricingService**: ≥ **85% branches**
- **Overall**: ≥ **90% lines**

Run:
```bash
mvn -q test
# then open target/site/jacoco/index.html
```

---

## CLI demo
```bash
mvn -q -DskipTests compile
# Example demo (after you implement PricingService):
java -cp target/classes capstone.Main
```

---

## Acceptance checklist
- [ ] Unit tests for thresholds & exceptions
- [ ] Data-driven tests using CSV/parameterized
- [ ] Interaction test covering validator scenarios
- [ ] WireMock tests covering 200/404/500/faults/malformed
- [ ] Coverage targets met (≥85% branches `PricingService`, ≥90% lines overall)

Good luck, and have fun building a genuinely useful slice of pricing logic!

