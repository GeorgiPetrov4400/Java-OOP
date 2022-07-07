package WorkingWithAbstractionLab.HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int seasonMultiplier;

    Season(int seasonMultiplier) {
        this.seasonMultiplier = seasonMultiplier;
    }

    public int getSeasonMultiplier() {
        return seasonMultiplier;
    }

    public static Season parse(String season) {
        return Season.valueOf(season.toUpperCase());
    }
}
