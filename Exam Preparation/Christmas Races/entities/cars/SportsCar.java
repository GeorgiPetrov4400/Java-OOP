package christmasRaces.entities.cars;

public class SportsCar extends BaseCar {

    private static final double CAR_CUBICCENTIMETERS = 3000;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CAR_CUBICCENTIMETERS);
    }
}
