//Piper Howell

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Account getAccount(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        return null;
    }

    public double getTotalDeposits() {
        double totalDeposits = 0;
        for (Account account : accounts) {
            ArrayList<String> transactions = account.getTransactions();
            for (String transaction : transactions) {
                if (transaction.startsWith("Deposit")) {
                    String[] parts = transaction.split(": ");
                    double amount = Double.parseDouble(parts[1]);
                    totalDeposits += amount;
                }
            }
        }
        return totalDeposits;
    }
}
