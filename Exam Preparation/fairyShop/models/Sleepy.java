package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int INITIAL_ENERGY_UNITS = 50;
    private static final int UNIT_WORKING_ENERGY = 15;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY_UNITS);
    }

    @Override
    public void work() {
        setEnergy(getEnergy() - UNIT_WORKING_ENERGY);
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }
}
