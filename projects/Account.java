public class Account {

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static long accountCounter = 0;

    private static String generateAccountNumber() {
        accountCounter++;
        return String.format("AC%04d", accountCounter);
    }

    // Constructor with owner name and opening balance
    public Account(String ownerName, long openingBalance) {

        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.active = true;
    }

    // Constructor with only owner name
    public Account(String ownerName) {

        this(ownerName, 0);
    }

    // Deposit money
    public void deposit(long amount) {

        if (amount < 0) {
            return;
        }

        balance = balance + amount;
    }

    // Withdraw money
    public boolean withdraw(long amount) {

        if (amount < 0) {
            return false;
        }

        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }

        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}