//Piper Howell

import java.util.ArrayList;

public class Account {
    private int accountId;
    private String firstName;
    private String lastName;
    private double balance;
    private ArrayList<String> transactions;

    public Account(int accountId, String firstName, String lastName) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setBalance(double amount) {
        balance = amount;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposit: " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add("Withdrawal: " + amount);
    }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }
}
