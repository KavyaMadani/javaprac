import java.util.Objects;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // toString()
    @Override
    public String toString() {
        return "Account Number: " + accountNumber
                + ", Owner Name: " + ownerName
                + ", Balance: " + balance;
    }

    // equals()
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Account)) {
            return false;
        }

        Account a = (Account) o;

        return accountNumber.equals(a.accountNumber);
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}