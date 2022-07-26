package VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");

        double carFuelQuantity = Double.parseDouble(carInput[1]);
        double carFuelConsumption = Double.parseDouble(carInput[2]);
        double carTankCapacity = Double.parseDouble(carInput[3]);
        Car car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);

        String[] truckInput = scanner.nextLine().split("\\s+");

        double truckFuelQuantity = Double.parseDouble(truckInput[1]);
        double truckFuelConsumption = Double.parseDouble(truckInput[2]);
        double truckTankCapacity = Double.parseDouble(truckInput[3]);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);

        String[] busInput = scanner.nextLine().split("\\s+");

        double busFuelQuantity = Double.parseDouble(busInput[1]);
        double busFuelConsumption = Double.parseDouble(busInput[2]);
        double busTankCapacity = Double.parseDouble(busInput[3]);
        Bus bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);

        int commandNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandNumber; i++) {

            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commandParts[2]);
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.drive(distance));
                    } else if (vehicleType.equals("Truck")) {
                        System.out.println(truck.drive(distance));
                    } else if (vehicleType.equals("Bus")) {
                        bus.setFuelConsumption(bus.getFuelConsumption() + Bus.ADDITIONAL_FULL_BUS_CONSUMPTION);
                        System.out.println(bus.drive(distance));
                        bus.setFuelConsumption(bus.getFuelConsumption() - Bus.ADDITIONAL_FULL_BUS_CONSUMPTION);
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commandParts[2]);
                    if (vehicleType.equals("Car")) {
                        car.refuel(liters);
                    } else if (vehicleType.equals("Truck")) {
                        truck.refuel(liters);
                    } else if (vehicleType.equals("Bus")) {
                        bus.refuel(liters);
                    }
                    break;
                case "DriveEmpty":
                    double distanceEmptyBus = Double.parseDouble(commandParts[2]);
                    System.out.println(bus.drive(distanceEmptyBus));
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }
}
