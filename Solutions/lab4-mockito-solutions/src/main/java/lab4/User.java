package lab4;

import java.util.Objects;

public class User {
    private final String username;
    private final String email;

    public User(String username, String email) {
        this.username = Objects.requireNonNull(username, "username");
        this.email = Objects.requireNonNull(email, "email");
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
}
