
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create accounts
        Account a1 = new Account("ACC001", "Alice", 1000.0, false);
        Account a2 = new Account("ACC002", "Bob", 2000.0, true); // overdraft allowed
        Account a3 = new Account("ACC003", "Charlie", 1500.0, false);
        Account a4 = new Account("ACC004", "Dan", 8000.0, false);

        // Add to bank
        bank.addAccount(a1);
        bank.addAccount(a2);
        bank.addAccount(a3);
        bank.addAccount(a4);

        // Perform transactions
        a1.deposit(500);
        a2.withdraw(2500); // Overdraft allowed
        bank.transfer("ACC003", "ACC001", 300);
        a4.withdraw(1000);

        // Print transaction history for Alice
        System.out.println("Transaction History for Alice:");
        for (String t : a1.getTransactionHistory()) {
            System.out.println("- " + t);
        }

        // Print top 3 richest accounts
        bank.printTop3Accounts();
    }
}
