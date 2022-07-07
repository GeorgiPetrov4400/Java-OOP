package WorkingWithAbstractionLab.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int days, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculatePrice() {
        return pricePerDay * days * season.getSeasonMultiplier() * discountType.getPriceReduction();
    }
}
