import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean overdraftProtection;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, String accountHolder, double initialBalance, boolean overdraftProtection) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.overdraftProtection = overdraftProtection;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean hasOverdraftProtection() {
        return overdraftProtection;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public boolean withdraw(double amount) {
        if (balance >= amount || overdraftProtection) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            return true;
        } else {
            transactionHistory.add("Withdrawal failed: Insufficient balance.");
            return false;
        }
    }
}
