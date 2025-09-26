package lab4;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> store = new HashMap<>();

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(store.get(username));
    }

    @Override
    public User save(User user) {
        store.put(user.getUsername(), user);
        return user;
    }
}
