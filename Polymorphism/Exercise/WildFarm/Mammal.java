package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;
    protected DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(), getAnimalName(), decimalFormat.format(getAnimalWeight()), livingRegion, getFoodEaten());
    }
}
