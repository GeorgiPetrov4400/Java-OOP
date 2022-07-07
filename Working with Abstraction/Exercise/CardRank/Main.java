package WorkingWithAbstractionExercise.CardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Ranks:");

        for (CardRank cardRank : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank.name());
        }

//        Arrays.stream(CardRank.values())
//                .forEach(cardRank -> System.out.printf("Ordinal value: %d; Name value: %s%n",
//                        cardRank.ordinal(), cardRank.name()));
    }
}
