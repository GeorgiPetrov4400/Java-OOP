package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        // TODO: 10-Aug-22 (==)

        if (animals.size() > capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        // TODO: 10-Aug-22 // animals.forEach(Animal::eat)
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s (%s):", name, getClass().getSimpleName()));
        builder.append(System.lineSeparator());

        if (getAnimals().isEmpty()) {
            builder.append("Animals: none");
        } else {
            builder.append("Animals:");
            for (Animal animal : getAnimals()) {
                builder.append(String.format(" %s", animal.getName()));
            }
        }
        builder.append(System.lineSeparator());
        builder.append(String.format("Foods: %d", getFoods().size()));
        builder.append(System.lineSeparator());
        builder.append(String.format("Calories: %d", sumCalories()));
        builder.append(System.lineSeparator());

        return builder.toString().trim();
    }
}
