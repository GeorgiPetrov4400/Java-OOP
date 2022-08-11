package zoo.entities.areas;

import zoo.entities.animals.Animal;

public class LandArea extends BaseArea {

    private static final int LAND_AREA_CAPACITY = 25;

    public LandArea(String name) {
        super(name, LAND_AREA_CAPACITY);
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append(String.format("%s (%s):", getName(), getClass().getSimpleName()));
//        builder.append(System.lineSeparator());
//
//        if (getAnimals().isEmpty()) {
//            builder.append("Animals: none");
//            builder.append(System.lineSeparator());
//        } else {
//            for (Animal animal : getAnimals()) {
//                builder.append(animal.getName());
//                builder.append(System.lineSeparator());
//            }
//        }
//
//        builder.append(String.format("Foods: %s", getFoods().size()));
//        builder.append(System.lineSeparator());
//        builder.append(String.format("Calories: %d", sumCalories()));
//        builder.append(System.lineSeparator());
//
//        return builder.toString().trim();
//    }
}
