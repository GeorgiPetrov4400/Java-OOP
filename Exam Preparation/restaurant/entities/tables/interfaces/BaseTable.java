package restaurant.entities.tables.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable = false;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    protected void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    protected void setAllPeople() {
        this.allPeople = allPeople;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return numberOfPeople * pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        setAllPeople();
        isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double foodBill = healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double beverageBill = beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return foodBill + beverageBill + allPeople();
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        isReservedTable = false;
        numberOfPeople = 0;
        allPeople = 0;
    }

    @Override
    public String tableInformation() {

        String tableType = getClass().getSimpleName();

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Table - %d", number));
        builder.append(System.lineSeparator());
        builder.append(String.format("Size - %d", size));
        builder.append(System.lineSeparator());
        builder.append(String.format("Type - %s", tableType));
        builder.append(System.lineSeparator());
        builder.append(String.format("All price - %.2f", pricePerPerson));

        return builder.toString().trim();
    }
}
