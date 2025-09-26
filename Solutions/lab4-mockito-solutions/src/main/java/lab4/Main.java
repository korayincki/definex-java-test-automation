package lab4;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -cp target/classes lab4.Main register <username> <email>");
            return;
        }
        InMemoryUserRepository repo = new InMemoryUserRepository();
        ConsoleEmailSender sender = new ConsoleEmailSender();
        NotificationService notifier = new NotificationService(repo, sender);
        UserService service = new UserService(repo, notifier);

        if ("register".equalsIgnoreCase(args[0]) && args.length == 3) {
            try {
                User u = service.register(args[1], args[2]);
                System.out.printf("Registered user: %s (%s)%n", u.getUsername(), u.getEmail());
            } catch (RuntimeException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } else {
            System.out.println("Invalid args. Usage: java -cp target/classes lab4.Main register <username> <email>");
        }
    }
}
