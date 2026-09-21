import java.util.Scanner;

public class NumberPatternAndSequence {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice;
        int rows;

        do {

            System.out.println("\n - NUMBER PATTERN AND SEQUENCE - ");
            System.out.println("1. Multiplication Triangle");
            System.out.println("2. Number Pyramid");
            System.out.println("3. Floyd's Triangle");
            System.out.println("4. Pascal-like Pattern");
            System.out.println("5. Hollow Rectangle");
            System.out.println("6. Diamond");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");
            choice = input.nextInt();

            if (choice >= 1 && choice <= 6) {

                System.out.print("Enter number of rows: ");
                rows = input.nextInt();

                switch (choice) {

                    case 1:
                        multiplicationTriangle(rows);
                        break;

                    case 2:
                        numberPyramid(rows);
                        break;

                    case 3:
                        floydsTriangle(rows);
                        break;

                    case 4:
                        pascalPattern(rows);
                        break;

                    case 5:
                        hollowRectangle(rows);
                        break;

                    case 6:
                        diamond(rows);
                        break;
                }

            } else if (choice != 7) {

                System.out.println("Invalid choice. Please try again.");

            }

        } while (choice != 7);

        System.out.println("Goodbye!");

        input.close();
    }


    // 1. Multiplication Triangle
    public static void multiplicationTriangle(int rows) {

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print((i * j) + " ");
            }

            System.out.println();
        }
    }


    // 2. Number Pyramid
    public static void numberPyramid(int rows) {

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++) {
            System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");
            }

            System.out.println();
        }
    }


    // 3. Floyd's Triangle
    public static void floydsTriangle(int rows) {

        int number = 1;

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(number + " ");
                number++;
            }

            System.out.println();
        }
    }


    // 4. Pascal-like Pattern
    public static void pascalPattern(int rows) {

        for (int i = 0; i < rows; i++) {

            int number = 1;

            for (int j = 1; j <= rows - i; j++) {
            System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {

                System.out.print(number + " ");

                number = number * (i - j) / (j + 1);
            }

            System.out.println();
        }
    }


    // 5. Hollow Rectangle
    public static void hollowRectangle(int rows) {

        int columns = rows;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (i == 0 || i == rows - 1 ||
                    j == 0 || j == columns - 1) {

                    System.out.print("* ");

                } else {

                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }


    // 6. Diamond
    public static void diamond(int rows) {

        // Upper half
        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++) {

                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {

                System.out.print("*");
            }

            System.out.println();
        }


        // Lower half
        for (int i = rows - 1; i >= 1; i--) {

            for (int j = 1; j <= rows - i; j++) {

                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {

                System.out.print("*");
            }

            System.out.println();
        }
    }
}