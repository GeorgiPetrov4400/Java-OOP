package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {

            String[] animalInfo = input.split("\\s+");
            if (animalInfo[0].equals("Cat")) {
                Animal cat = new Cat(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3], animalInfo[4]);
                animals.add(cat);
            } else if (animalInfo[0].equals("Mouse")) {
                Animal mouse = new Mouse(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                animals.add(mouse);
            } else if (animalInfo[0].equals("Tiger")) {
                Animal tiger = new Tiger(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                animals.add(tiger);
            } else if (animalInfo[0].equals("Zebra")) {
                Animal zebra = new Zebra(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                animals.add(zebra);
            }

            String[] foodInfo = input.split("\\s+");
            if (foodInfo[0].equals("Vegetable")) {
                Food vegetable = new Vegetable(Integer.parseInt(foodInfo[1]));
                foods.add(vegetable);
            } else if (foodInfo[0].equals("Meat")) {
                Food meat = new Meat(Integer.parseInt(foodInfo[1]));
                foods.add(meat);
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            Food food = foods.get(i);

            animal.makeSound();
            animal.eat(food);
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }
}
