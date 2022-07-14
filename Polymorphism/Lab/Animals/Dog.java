package PolymorphismLab.Animals;

public class Dog extends Animal {

    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am Rocky and my favourite food is Meat%n" +
                "DJAAF", super.name, super.favouriteFood);
    }
}
