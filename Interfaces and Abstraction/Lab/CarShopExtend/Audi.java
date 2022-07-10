package InterfacesAndAbstractionLab.CarShopExtend;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;


    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return 3;
    }

    @Override
    public Double getPricePerDay() {
        return 99.9;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("This is %s produced in %s and have %d tires%n", getModel(), countryProduced(), TIRES));
        builder.append(String.format("Minimum rental period of %d days. Price per day %f", getMinRentDay(), getPricePerDay()));
        return builder.toString();
    }
}
