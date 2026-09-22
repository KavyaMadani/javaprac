public class MiniBank {

    public static void main(String[] args) {

        Account[] accounts = new Account[3];

        accounts[0] = new Account("Kavya", 1000);
        accounts[1] = new Account("Rahul", 2000);
        accounts[2] = new Account("Priya");

        // Deposits
        accounts[0].deposit(500);
        accounts[1].deposit(1000);
        accounts[2].deposit(1500);

        // Withdrawals
        accounts[0].withdraw(200);
        accounts[1].withdraw(500);
        accounts[2].withdraw(300);

        // Print account details
        for (Account account : accounts) {

            System.out.println("-------------------------");
            System.out.println("Account Number: "
                    + account.getAccountNumber());

            System.out.println("Owner: "
                    + account.getOwnerName());

            System.out.println("Balance: ₹"
                    + account.getBalance());

            System.out.println("Active: "
                    + account.isActive());
        }
    }
}