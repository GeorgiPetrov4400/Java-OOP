package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int readNumber = Integer.parseInt(scanner.nextLine());
            if (readNumber <= 0) {
                throw new IllegalArgumentException("Invalid");
            }
            double rootNumber = Math.sqrt(readNumber);
            System.out.printf("%.2f%n", rootNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
