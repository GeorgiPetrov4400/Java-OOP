package WorkingWithAbstractionExercise.CardsWithPower;

public class Card {
    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public RankPower getRankPower() {
        return rankPower;
    }

    public SuitPower getSuitPower() {
        return suitPower;
    }

    public int getPower(RankPower rankPower, SuitPower suitPower) {
        return rankPower.getRankPower() + suitPower.getSuitPower();
    }
}
