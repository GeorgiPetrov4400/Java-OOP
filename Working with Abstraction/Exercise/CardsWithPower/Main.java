package WorkingWithAbstractionExercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RankPower rankPower = RankPower.valueOf(scanner.nextLine());
        SuitPower suitPower = SuitPower.valueOf(scanner.nextLine());

        Card card = new Card(rankPower, suitPower);

        System.out.printf("Card name: %s of %s; Card power: %d%n",
                card.getRankPower().name(), card.getSuitPower().name(), card.getPower(rankPower, suitPower));

    }
}
