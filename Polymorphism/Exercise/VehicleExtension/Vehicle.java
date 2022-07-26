package VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        double neededFuel = distance * fuelConsumption;

        if (neededFuel > fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        this.fuelQuantity -= neededFuel;
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        if (liters > this.tankCapacity - this.fuelQuantity) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }

        this.fuelQuantity += liters;
    }
}
