import java.util.Scanner;

public class ATMCashDenominationSimulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ATM bill variables
        int withdraw = 0;
        int oneThousand = 1000;
        int fiveHundred = 500;
        int twoHundred = 200;
        int oneHundred = 100;
        int fifty = 50;
        int twenty = 20;

        // Bill counter variables
        int oneThousandCount = 0;
        int fiveHundredCount = 0;
        int twoHundredCount = 0;
        int oneHundredCount = 0;
        int fiftyCount = 0;
        int twentyCount = 0;
        int totalBills = 0;

        do {
            System.out.print("Withdrawal: ₱");
            withdraw = scanner.nextInt();

            int remainAmount = 0;
            while (withdraw != 0) {
                if (withdraw >= 1000) {
                    remainAmount = withdraw % oneThousand;


                    withdraw /= oneThousand;
                    oneThousandCount = withdraw;

                    withdraw -= withdraw;
                    withdraw += remainAmount;
                }
                if (withdraw >= 500) {
                    remainAmount = withdraw % fiveHundred;


                    withdraw /= fiveHundred;
                    fiveHundredCount = withdraw;

                    withdraw -= withdraw;
                    withdraw += remainAmount;
                }
                if (withdraw >= 200) {
                    remainAmount = withdraw % twoHundred;

                    withdraw /= twoHundred;
                    twoHundredCount = withdraw;

                    withdraw -= withdraw;
                    withdraw += remainAmount;
                }
                if (withdraw >= 100) {
                    remainAmount = withdraw % oneHundred;

                    withdraw /= oneHundred;
                    oneHundredCount = withdraw;

                    withdraw -= withdraw;
                    withdraw += remainAmount;
                }
                if (withdraw >= 50) {
                    remainAmount = withdraw % fifty;

                    withdraw /= fifty;
                    fiftyCount = withdraw;

                    withdraw -= withdraw;
                    withdraw += remainAmount;
                }
                if (withdraw >= 20) {
                    remainAmount = withdraw % twenty;

                    withdraw /= twenty;
                    twentyCount = withdraw;

                    withdraw -= withdraw;
                    withdraw += remainAmount;
                }
                if (withdraw == 0) {
                    totalBills += (oneThousandCount + fiveHundredCount + twoHundredCount + oneHundredCount + fiftyCount + twentyCount);

                    System.out.println("\n₱1000 bills: " + oneThousandCount);
                    System.out.println("₱500 bills: " + fiveHundredCount);
                    System.out.println("₱200 bills: " + twoHundredCount);
                    System.out.println("₱100 bills: " + oneHundredCount);
                    System.out.println("₱50 bills: " + fiftyCount);
                    System.out.println("₱20 bills: " + twentyCount);

                    System.out.println("\nRemaining amount: ₱" + remainAmount);
                    System.out.println("Total bills: " + totalBills);
                    break;
                }
                if (withdraw < 20 && withdraw > 0) {
                    System.out.println("\nERROR: Amount to withdraw cannot be represented using available denominations!");
                    System.out.println("Please try again.\n");

                    remainAmount = 0;
                    oneThousandCount = 0;
                    fiveHundredCount = 0;
                    twoHundredCount = 0;
                    oneHundredCount = 0;
                    fiftyCount = 0;
                    twentyCount = 0;
                    totalBills = 0;
                    break;
                }
            }
        } while (totalBills == 0);

        scanner.close();
    }
}