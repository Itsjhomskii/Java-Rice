import java.util.Scanner;

public class bankTransaction {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double startingBalance;
        double balance;
        double deposit;
        double withdrawal;
        int choice;

        double totalDeposits = 0;
        double totalWithdrawals = 0;
        double largestDeposit = 0;
        double largestWithdrawal = 0;
        int transactions = 0;

        System.out.print("Enter initial balance: $");
        startingBalance = input.nextDouble();

        balance = startingBalance;

        do {

            System.out.println("\n===== BANKING SYSTEM =====");
            System.out.printf("Balance: $%.2f%n%n", balance);

            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction Summary");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Deposit amount: $");
                    deposit = input.nextDouble();

                    balance += deposit;
                    totalDeposits += deposit;
                    transactions++;

                    if (deposit > largestDeposit) {
                        largestDeposit = deposit;
                    }

                    System.out.printf("Deposit successful.%n");
                    System.out.printf("New balance: $%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Withdrawal amount: $");
                    withdrawal = input.nextDouble();

                    if (withdrawal > balance) {
                        System.out.println("Withdrawal declined: insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        totalWithdrawals += withdrawal;
                        transactions++;

                        if (withdrawal > largestWithdrawal) {
                            largestWithdrawal = withdrawal;
                        }

                        System.out.printf("Withdrawal successful.%n");
                        System.out.printf("New balance: $%.2f%n", balance);
                    }
                    break;

                case 3:
                    System.out.print("Transfer amount: $");
                    withdrawal = input.nextDouble();

                    if (withdrawal > balance) {
                        System.out.println("Transfer declined: insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        totalWithdrawals += withdrawal;
                        transactions++;

                        if (withdrawal > largestWithdrawal) {
                            largestWithdrawal = withdrawal;
                        }

                        System.out.printf("Transfer successful.%n");
                        System.out.printf("New balance: $%.2f%n", balance);
                    }
                    break;

                case 4:
                    System.out.printf("Current balance: $%.2f%n", balance);
                    break;

                case 5:
                    transactionSummary(
                        startingBalance,
                        balance,
                        totalDeposits,
                        totalWithdrawals,
                        transactions,
                        largestDeposit,
                        largestWithdrawal
                    );
                    break;

                case 6:
                    transactionSummary(
                        startingBalance,
                        balance,
                        totalDeposits,
                        totalWithdrawals,
                        transactions,
                        largestDeposit,
                        largestWithdrawal
                    );

                    System.out.println("\nThank you for using the banking system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        input.close();
    }


    // Transaction Summary
    public static void transactionSummary(
            double startingBalance,
            double balance,
            double totalDeposits,
            double totalWithdrawals,
            int transactions,
            double largestDeposit,
            double largestWithdrawal) {

        System.out.println("\n===== TRANSACTION SUMMARY =====");

        System.out.printf("Starting Balance: $%.2f%n", startingBalance);
        System.out.printf("Final Balance: $%.2f%n", balance);
        System.out.printf("Total Deposits: $%.2f%n", totalDeposits);
        System.out.printf("Total Withdrawals: $%.2f%n", totalWithdrawals);
        System.out.println("Number of Transactions: " + transactions);
        System.out.printf("Largest Deposit: $%.2f%n", largestDeposit);
        System.out.printf("Largest Withdrawal: $%.2f%n", largestWithdrawal);
    }
}