package ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int startOfRange = Integer.parseInt(input[0]);
        int endOfRange = Integer.parseInt(input[1]);

        System.out.printf("Range: [%d...%d]%n", startOfRange, endOfRange);

        String line = scanner.nextLine();

        while (true) {
            try {
                int number = Integer.parseInt(line);
                if (number >= startOfRange && number <= endOfRange) {
                    System.out.printf("Valid number: %d%n", number);
                    break;
                } else {
                    System.out.printf("Invalid number: %s%n", line);
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("Invalid number: %s%n", line);
            }

            line = scanner.nextLine();
        }
    }
}
