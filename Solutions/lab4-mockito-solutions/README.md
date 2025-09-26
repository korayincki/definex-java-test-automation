# Lab 4 — Mockito: Interaction Testing — Solutions

This project contains **fully-implemented Mockito tests** for:
- `UserService.register`: happy path, duplicate username, invalid input
- `NotificationService.notifyUser`: happy path with argument capture, and missing user

The code uses **JUnit 5** + **Mockito 5** with the JUnit Jupiter extension.

## Environment / Setup
- **JDK**: 17
- **Maven**: 3.9+ (internet access for dependencies)
- No special Mockito configuration is required (no inline mock maker needed; we are not mocking final/static).

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
This runs a helper (`tools.SurefireTablePrinter`) bound to the `verify` phase via the `exec-maven-plugin` and prints a neat ASCII table by reading `target/surefire-reports`.

### Running a single test
```bash
mvn -q -Dtest=UserServiceTest test
```

---

## Project structure
- **Domain**
  - `lab4.User`, `lab4.UserRepository`, `lab4.EmailSender`
  - `lab4.NotificationService` (looks up user and calls `EmailSender.send(to, subject, body)`)
  - `lab4.UserService` (validates, checks duplicates, saves user, then notifies)
- **Tests** (all passing)
  - `lab4/UserServiceTest.java` (Mockito: stubbing, verify, never, InOrder, ArgumentCaptor)
  - `lab4/NotificationServiceTest.java` (Mockito: stubbing, verify, ArgumentCaptor)
- **CLI** (demo)
  - `lab4.Main` with an in-memory repo and console email sender

---

## Notes on Mockito usage in this lab
- We use `@ExtendWith(MockitoExtension.class)`, `@Mock`, and `@InjectMocks`.
- Stubbing with `when(...).thenReturn(...)` and verification with `verify(...)`.
- `never()` to ensure an interaction **did not** happen.
- `ArgumentCaptor` to assert subject/body content (e.g., subject contains "Welcome", body contains the username).
- Optional: `InOrder` to verify `save(...)` happens before `notifyUser(...)`.

Everything is self-contained; just run the commands above to see passing tests and reports.
