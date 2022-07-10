package InterfacesAndAbstractionLab.CarShopExtend;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;

    }

    @Override
    public Double getPrice() {
        return 11111.1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("This is %s produced in %s and have %d tires%n", getModel(), countryProduced(), TIRES));
        builder.append(String.format("%s sells for %f", getModel(), getPrice()));
        return builder.toString();
    }
}
