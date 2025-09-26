package lab3;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        if (args.length == 0) {
            System.out.println("Usage: java -cp target/classes lab3.Main D <amount> [W <amount> ...] BAL");
            System.out.println("Example: java -cp target/classes lab3.Main D 100 W 30 BAL");
            return;
        }
        int i = 0;
        while (i < args.length) {
            String cmd = args[i++].toUpperCase();
            try {
                switch (cmd) {
                    case "D":
                    case "DEPOSIT":
                        int d = Integer.parseInt(args[i++]);
                        account.deposit(d);
                        System.out.printf("Deposit %d -> balance=%d%n", d, account.getBalance());
                        break;
                    case "W":
                    case "WITHDRAW":
                        int w = Integer.parseInt(args[i++]);
                        account.withdraw(w);
                        System.out.printf("Withdraw %d -> balance=%d%n", w, account.getBalance());
                        break;
                    case "BAL":
                    case "BALANCE":
                        System.out.printf("BAL -> balance=%d%n", account.getBalance());
                        break;
                    default:
                        System.out.printf("Unknown command: %s%n", cmd);
                }
            } catch (UnsupportedOperationException uoe) {
                System.out.println("Not implemented yet: " + uoe.getMessage());
                return;
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                System.out.println("Missing amount after command.");
                return;
            } catch (NumberFormatException nfe) {
                System.out.println("Amount must be an integer.");
                return;
            } catch (RuntimeException re) {
                System.out.println("Error: " + re.getMessage());
                return;
            }
        }
    }
}
