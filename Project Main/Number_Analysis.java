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
            } else if (isCount) {
                compositeCount++;
            }
        }
        // For Even And Odd Numbers

        // For Palindrome Numbers
        int original = start;
        while (original <= end) {
            int reversed = 0;
            int temp = original;

            while (temp != 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }

            if (original == reversed) {
                palindromeCount++;
            }
            original++;
        
        }

        // For Armstrong Numbers

        // For Perfect Numbers

        // For Abundant Numbers

        // For Deficient Numbers

        
        System.out.println("\nPrime Numbers: " + primeCount);
        System.out.println("Composite Numbers: " + compositeCount);
        System.out.println("Even Numbers: " + evenCount);
        System.out.println("Odd Numbers: " + oddCount);
        System.out.println("Palindrome Numbers: " + palindromeCount);
        System.out.println("Armstrong Numbers: " + armstrongCount);
        System.out.println("Perfect Numbers: " + perfectCount);
        System.out.println("Abundant Numbers: " + abundantCount);
        System.out.println("Deficient Numbers: " + deficientCount);
    }
}