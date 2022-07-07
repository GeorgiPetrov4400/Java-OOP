package EncapsulationExercise.ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> productMap = new HashMap<>();

        String[] peopleInput = scanner.nextLine().split(";");

        for (String personData : peopleInput) {
            String[] personDataParts = personData.split("=");
            String name = personDataParts[0];
            double money = Double.parseDouble(personDataParts[1]);
            try {
                Person person = new Person(name, money);
                personMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsInput = scanner.nextLine().split(";");

        for (String productData : productsInput) {
            String[] productDataParts = productData.split("=");
            String name = productDataParts[0];
            double cost = Double.parseDouble(productDataParts[1]);
            try {
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            String personName = data[0];
            String productName = data[1];

            Person buyer = personMap.get(personName);
            Product productToBuy = productMap.get(productName);
            try {
                buyer.buyProduct(productToBuy);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        personMap.values().forEach(System.out::println);
    }
}

