package christmasRaces.entities.cars;

public class MuscleCar extends BaseCar {

    private static final double CAR_CUBICCENTIMETERS = 5000;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CAR_CUBICCENTIMETERS);
    }


}
