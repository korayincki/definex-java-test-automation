# Lab 4 — Mockito: Interaction Testing

**Goal**: Isolate service logic and verify interactions.  
**Required**: Tests for `UserService.register` (happy path, duplicate, invalid).

## Steps
1. Create `UserServiceTest` using Mockito extension (`@ExtendWith(MockitoExtension.class)`).
2. Use `@Mock` and `@InjectMocks`; stub with `when(...).thenReturn(...)`.
3. Verify interactions; use `never()` and `ArgumentCaptor` where relevant.
4. Run tests and check coverage.

## Expected results
- Interaction tests fail if repo behavior changes incorrectly.

---

# Lab 4 – Mockito (Mocking & Captors)

## Background
This lab teaches mocking and verification of interactions using Mockito.  
Mocks allow testing units in isolation without calling real dependencies.

## Application
The application is a **Notification Service** that sends emails when a user registers.  
Actual email sending is delegated to an `EmailSender` dependency.

### Rules
- When `notifyUser(username)` is called, the system should:
  - Look up the user’s email address.
  - Call `EmailSender.send(email, subject, body)`.
- If the user does not exist, an exception should be raised.
- Mocks are used to verify:
  - Correct email address is used.
  - Subject line includes "Welcome".
  - Message body contains the username.

### Example expectation
- `notifyUser("john")` → triggers a call to `EmailSender.send("john@example.com", "Welcome", "Hello john")`

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
A tiny CLI is included to exercise user registration + notification with a console email sender.

Build and run:
```bash
mvn -q -DskipTests compile
java -cp target/classes lab4.Main register john john@example.com
```
