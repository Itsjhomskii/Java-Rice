import java.util.Scanner;

public class Number_Analysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int start;
        int end;
        int primeCount = 0;
        int compositeCount = 0; 
        int evenCount = 0;
        int oddCount = 0;
        int palindromeCount = 0;
        int armstrongCount = 0;
        int perfectCount = 0;
        int abundantCount = 0;
        int deficientCount = 0;
        int largestPrimeNum = 0;
        int largestArmstrongNum = 0;
        int largestPerfectNum = 0;

        System.out.print("Start: ");
        start = input.nextInt();

        System.out.print("End: ");
        end = input.nextInt();
        
        // For Prime & Composite Numbers
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;
            boolean isCount = true;

            if (i <= 1) {
                isPrime = false;
                isCount = false;
            } else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                primeCount++;
                largestPrimeNum = i;
            } else if (isCount) {
                compositeCount++;
            }
        }
        // For Even And Odd Numbers

        // For Palindrome Numbers
        int original = start;
        while (original <= end) {
            int reversed = 0;
            int temporary = original;

            while (temporary != 0) {
                int digit = temporary % 10;
                reversed = reversed * 10 + digit;
                temporary /= 10;
            }

            if (original == reversed) {
                palindromeCount++;
            }
            original++;
        
        }

        // For Armstrong Numbers

        // For Perfect, Abundant, and Deficient Numbers
        for (int i = start; i <= end; i++) {
            if (i <= 1) {
                deficientCount++;
                continue;
            }
            
            // Calculate the sum of divisors of start variable
            int sum = 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sum += j;
                    if (j != i / j) {
                        sum += i / j;
                    }
                }
            }

            // Check if sum is equal, lesser than, or greater than start variable
            if (sum == i) {
                perfectCount++;
                largestPerfectNum = i;
            } else if (sum > i) {
                abundantCount++;
            } else {
                deficientCount++;
            }
        }

        System.out.println("\n====== NUMBER ANALYSIS REPORT ======");

        System.out.println("\nRange: " + start + " - " + end);
        
        System.out.println("\nPrime Numbers: " + primeCount);
        System.out.println("Composite Numbers: " + compositeCount);
        System.out.println("Even Numbers: " + evenCount);
        System.out.println("Odd Numbers: " + oddCount);

        System.out.println("\nPalindrome Numbers: " + palindromeCount);
        System.out.println("Armstrong Numbers: " + armstrongCount);
        System.out.println("Perfect Numbers: " + perfectCount);
        System.out.println("Abundant Numbers: " + abundantCount);
        System.out.println("Deficient Numbers: " + deficientCount);

        System.out.println("\nLargest Prime: " + largestPrimeNum);
        System.out.println("Largest Perfect Number: " + largestPerfectNum);
        System.out.println("Largest Armstrong Number: " + largestArmstrongNum);
    }
}