import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public boolean transfer(String fromAcc, String toAcc, double amount) {
        Account sender = findAccount(fromAcc);
        Account receiver = findAccount(toAcc);
        if (sender == null || receiver == null) {
            System.out.println("Transfer failed: Account not found.");
            return false;
        }
        if (sender.withdraw(amount)) {
            receiver.deposit(amount);
            sender.getTransactionHistory().add("Transferred " + amount + " to " + toAcc);
            receiver.getTransactionHistory().add("Received " + amount + " from " + fromAcc);
            return true;
        } else {
            System.out.println("Transfer failed: Insufficient funds.");
            return false;
        }
    }

    public void printTop3Accounts() {
        ArrayList<Account> sorted = new ArrayList<>(accounts);
        sorted.sort((a, b) -> Double.compare(b.getBalance(), a.getBalance()));

        System.out.println("\nTop 3 Accounts by Balance:");
        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            Account acc = sorted.get(i);
            System.out.println((i + 1) + ". " + acc.getAccountHolder() + " (" + acc.getAccountNumber() + ") - Balance: " + acc.getBalance());
        }
    }
}
