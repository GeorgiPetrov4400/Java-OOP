package WorkingWithAbstractionExercise.CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(input + ":");
//        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.CLUBS.ordinal(), CardSuit.CLUBS.name());
//        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.DIAMONDS.ordinal(), CardSuit.DIAMONDS.name());
//        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.HEARTS.ordinal(), CardSuit.HEARTS.name());
//        System.out.printf("Ordinal value: %d; Name value: %s%n", CardSuit.SPADES.ordinal(), CardSuit.SPADES.name());

        Arrays.stream(CardSuit.values())
                .forEach(cardSuit -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.ordinal(), cardSuit.name()));
    }
}
