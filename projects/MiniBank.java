import java.util.Scanner;

public class MiniBank {

    record BankInfo(String name, String branch) {
    }

    enum MenuOption {
        OPEN_ACCOUNT,
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        EXIT
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankInfo bank = new BankInfo("MiniBank", "Main Branch");

        System.out.println("================================");
        System.out.println(bank);
        System.out.println("================================");

        boolean running = true;

        while (running) {

            System.out.println("\n===== MiniBank Menu =====");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            String result = switch (choice) {

                case 1 -> "Open Account — to be implemented in a later lab";

                case 2 -> "Deposit — to be implemented in a later lab";

                case 3 -> "Withdraw — to be implemented in a later lab";

                case 4 -> "Transfer — to be implemented in a later lab";

                case 5 -> {
                    running = false;
                    yield "Exit selected";
                }

                default -> "Invalid choice";
            };

            System.out.println(result);
        }

        System.out.println("Thank you for using MiniBank!");

        sc.close();
    }
}