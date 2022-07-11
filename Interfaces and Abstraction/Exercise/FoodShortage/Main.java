package InterfacesAndAbstractionExercise.FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Citizen> citizenMap = new HashMap<>();

        Map<String, Rebel> rebelMap = new HashMap<>();


        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 4) {
                String citizenName = input[0];
                int citizenAge = Integer.parseInt(input[1]);
                String citizenId = input[2];
                String citizenBirthdayDate = input[3];
                Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthdayDate);
                citizenMap.put(citizenName, citizen);
            } else if (input.length == 3) {
                String rebelName = input[0];
                int rebelAge = Integer.parseInt(input[1]);
                String rebelGroup = input[2];
                Rebel rebel = new Rebel(rebelName, rebelAge, rebelGroup);
                rebelMap.put(rebelName, rebel);
            }
        }

        String nameInput = scanner.nextLine();

        while (!"End".equals(nameInput)) {
            for (Citizen citizen : citizenMap.values()) {
                if (citizen.getName().equals(nameInput)) {
                    citizen.buyFood();
                }
            }

            for (Rebel rebel : rebelMap.values()) {
                if (rebel.getName().equals(nameInput)) {
                    rebel.buyFood();
                }
            }

            nameInput = scanner.nextLine();
        }

        int sumPurchasedFood = 0;

        for (Citizen citizen : citizenMap.values()) {
            sumPurchasedFood += citizen.getFood();
        }
        for (Rebel rebel : rebelMap.values()) {
            sumPurchasedFood += rebel.getFood();
        }

        System.out.println(sumPurchasedFood);
    }
}
