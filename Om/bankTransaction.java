import java.util.*;

public class bankTransaction {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double startingBalance = readNonNegativeAmount(sc, "Enter initial balance: $");
    double balance = startingBalance;
    double totalDeposits = 0;
    double totalWithdrawals = 0;
    double largestDeposit = 0;
    double largestWithdrawal = 0;
    int transactionCount = 0;
    int choice;

    do {
      System.out.println("\nBANKING SYSTEM");
      System.out.printf("Balance: $%,.2f%n%n", balance);
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Transfer");
      System.out.println("4. Check Balance");
      System.out.println("5. Transaction Summary");
      System.out.println("6. Exit");
      choice = readInteger(sc, "Choice: ");

      switch (choice) {
        case 1: {
          double amount = readPositiveAmount(sc, "Deposit amount: $");
          balance += amount;
          totalDeposits += amount;
          largestDeposit = Math.max(largestDeposit, amount);
          transactionCount++;
          System.out.printf("Deposit successful.%nNew balance: $%,.2f%n", balance);
          break;
        }
        case 2: {
          double amount = readPositiveAmount(sc, "Withdrawal amount: $");
          if (amount > balance) {
            System.out.println("Withdrawal declined: insufficient balance.");
          } else {
            balance -= amount;
            totalWithdrawals += amount;
            largestWithdrawal = Math.max(largestWithdrawal, amount);
            transactionCount++;
            System.out.printf("Withdrawal successful.%nNew balance: $%,.2f%n", balance);
          }
          break;
        }
        case 3: {
          double amount = readPositiveAmount(sc, "Transfer amount: $");
          if (amount > balance) {
            System.out.println("Transfer declined: insufficient balance.");
          } else {
            balance -= amount;
            totalWithdrawals += amount;
            largestWithdrawal = Math.max(largestWithdrawal, amount);
            transactionCount++;
            System.out.printf("Transfer successful.%nNew balance: $%,.2f%n", balance);
          }
          break;
        }
        case 4:
          System.out.printf("Current balance: $%,.2f%n", balance);
          break;
        case 5:
          printSummary(startingBalance, balance, totalDeposits, totalWithdrawals,
              transactionCount, largestDeposit, largestWithdrawal);
          break;
        case 6:
          printSummary(startingBalance, balance, totalDeposits, totalWithdrawals,
              transactionCount, largestDeposit, largestWithdrawal);
          System.out.println("Thank you for using the banking system.");
          break;
        default:
          System.out.println("Invalid choice. Please select 1 through 6.");
      }
    } while (choice != 6);

    sc.close();
  }

  private static int readInteger(Scanner sc, String prompt) {
    while (true) {
      System.out.print(prompt);
      if (sc.hasNextInt()) {
        return sc.nextInt();
      }
      System.out.println("Please enter a whole number.");
      sc.next();
    }
  }

  private static double readNonNegativeAmount(Scanner sc, String prompt) {
    while (true) {
      System.out.print(prompt);
      if (sc.hasNextDouble()) {
        double amount = sc.nextDouble();
        if (Double.isFinite(amount) && amount >= 0) {
          return amount;
        }
      } else {
        sc.next();
      }
      System.out.println("Please enter a valid non-negative amount.");
    }
  }

  private static double readPositiveAmount(Scanner sc, String prompt) {
    while (true) {
      double amount = readNonNegativeAmount(sc, prompt);
      if (amount > 0) {
        return amount;
      }
      System.out.println("The amount must be greater than zero.");
    }
  }

  private static void printSummary(double startingBalance, double balance,
      double totalDeposits, double totalWithdrawals, int transactionCount,
      double largestDeposit, double largestWithdrawal) {
    System.out.println("\nTRANSACTION SUMMARY");
    System.out.printf("Starting Balance: $%,.2f%n", startingBalance);
    System.out.printf("Final Balance: $%,.2f%n", balance);
    System.out.printf("Total Deposits: $%,.2f%n", totalDeposits);
    System.out.printf("Total Withdrawals: $%,.2f%n", totalWithdrawals);
    System.out.println("Number of Transactions: " + transactionCount);
    System.out.printf("Largest Deposit: $%,.2f%n", largestDeposit);
    System.out.printf("Largest Withdrawal: $%,.2f%n", largestWithdrawal);
  }
}