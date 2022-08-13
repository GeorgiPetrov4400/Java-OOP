package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalBills;


    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
        this.totalBills = 0;

    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood healthyFood = null;
        String foodType = null;

        switch (type) {
            case "Salad":
                healthyFood = new Salad(name, price);
                foodType = "Salad";
                break;
            case "VeganBiscuits":
                healthyFood = new VeganBiscuits(name, price);
                foodType = "VeganBiscuits";
                break;
        }

        for (HealthyFood entity : healthFoodRepository.getAllEntities()) {
            if (entity.getName().equals(foodType)) {
                throw new IllegalArgumentException(String.format(FOOD_EXIST, foodType));
            }
        }

        healthFoodRepository.add(healthyFood);

        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = null;
        String beverageType = null;

        switch (type) {
            case "Fresh":
                beverage = new Fresh(name, counter, brand);
                beverageType = "Fresh";
                break;
            case "Smoothie":
                beverage = new Smoothie(name, counter, brand);
                beverageType = "Smoothie";
                break;
        }

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, beverageType));
        }

        beverageRepository.add(beverage);

        return String.format(BEVERAGE_ADDED, beverageType, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        // String tableType = null;

        switch (type) {
            case "Indoors":
                table = new Indoors(tableNumber, capacity);
                //     tableType = "Indoors";
                break;
            case "InGarden":
                table = new InGarden(tableNumber, capacity);
                //     tableType = "InGarden";
                break;
        }

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }

        tableRepository.add(table);

        return String.format(TABLE_EXIST, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        int tableNumber;

        for (Table table : tableRepository.getAllEntities()) {
            if (!table.isReservedTable() && numberOfPeople <= table.getSize()) {
                tableNumber = table.getTableNumber();
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, tableNumber, numberOfPeople);

            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {

        Table existingTable = tableRepository.byNumber(tableNumber);

        if (existingTable == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood existingFood = healthFoodRepository.foodByName(healthyFoodName);

        if (existingFood == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        existingTable.orderHealthy(existingFood);

        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {

        Table existingTable = tableRepository.byNumber(tableNumber);
        Beverages existingBeverage = beverageRepository.beverageByName(name, brand);

        if (existingTable == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (existingBeverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        existingTable.orderBeverages(existingBeverage);

        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table foundTable = tableRepository.byNumber(tableNumber);

        double tableBill = foundTable.bill();
        totalBills += tableBill;
        foundTable.clear();

        return String.format(BILL, tableNumber, tableBill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalBills);
    }
}
