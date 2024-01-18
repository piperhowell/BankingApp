//Piper Howell

import java.util.Scanner;

public class BankDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("Welcome to the bank! What would you like to do?");
            System.out.println("1. Add account");
            System.out.println("2. Remove account");
            System.out.println("3. Deposit money");
            System.out.println("4. Withdraw money");
            System.out.println("5. Get account information");
            System.out.println("6. Get total deposits");
            System.out.println("7. Exit");

            int choice = input.nextInt();
            input.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter account ID:");
                    int accountId = input.nextInt();
                    input.nextLine(); // Consume the newline character
                    System.out.println("Enter first name:");
                    String firstName = input.nextLine();
                    System.out.println("Enter last name:");
                    String lastName = input.nextLine();
                    Account account = new Account(accountId, firstName, lastName);
                    bank.addAccount(account);
                    System.out.println("Account added!");
                    break;

                case 2:
                    System.out.println("Enter account ID:");
                    int removeId = input.nextInt();
                    input.nextLine(); // Consume the newline character
                    Account removeAccount = bank.getAccount(removeId);
                    if (removeAccount == null) {
                        System.out.println("Account not found!");
                    } else {
                        bank.removeAccount(removeAccount);
                        System.out.println("Account removed!");
                    }
                    break;

                case 3:
                    System.out.println("Enter account ID:");
                    int depositId = input.nextInt();
                    input.nextLine(); // Consume the newline character
                    Account depositAccount = bank.getAccount(depositId);
                    if (depositAccount == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = input.nextDouble();
                        input.nextLine(); // Consume the newline character
                        depositAccount.deposit(depositAmount);
                        System.out.println("Deposit successful!");
                    }
                    break;

                case 4:
                    System.out.println("Enter account ID:");
                    int withdrawId = input.nextInt();
                    input.nextLine(); // Consume the newline character
                    Account withdrawAccount = bank.getAccount(withdrawId);
                    if (withdrawAccount == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = input.nextDouble();
                        input.nextLine(); // Consume the newline character
                        if (withdrawAmount > withdrawAccount.getBalance()) {
                            System.out.println("Insufficient funds!");
                        } else {
                            withdrawAccount.withdraw(withdrawAmount);
                            System.out.println("Withdrawal successful!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Enter account ID:");
                    int infoId = input.nextInt();
                    input.nextLine(); // Consume the newline character
                    Account infoAccount = bank.getAccount(infoId);
                    if (infoAccount == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("First name: " + infoAccount.getFirstName());
                        System.out.println("Last name: " + infoAccount.getLastName());
                        System.out.println("Balance: " + infoAccount.getBalance());
                        System.out.println("Transaction history:");
                        for (String transaction : infoAccount.getTransactions()) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 6:
                    double totalDeposits = bank.getTotalDeposits();
                    System.out.println("Total deposits: " + totalDeposits);
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
