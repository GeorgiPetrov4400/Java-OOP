package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carInput[1]);
        double carFuelConsumption = Double.parseDouble(carInput[2]);
        Car car = new Car(carFuelQuantity, carFuelConsumption);

        String[] truckInput = scanner.nextLine().split("\\s+");

        double truckFuelQuantity = Double.parseDouble(truckInput[1]);
        double truckFuelConsumption = Double.parseDouble(truckInput[2]);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int commandNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandNumber; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String className = commandParts[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commandParts[2]);
                    if (className.equals("Car")) {
                        System.out.println(car.drive(distance));
                    } else if (className.equals("Truck")) {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commandParts[2]);
                    if (className.equals("Car")) {
                        car.refuel(liters);
                    } else if (className.equals("Truck")) {
                        truck.refuel(liters);
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }
}
