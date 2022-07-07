package EncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            products.add(product);
            money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", getName(), product.getName()));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + " - ");
        String productData = products.stream().map(Product::getName).collect(Collectors.joining(", "));
        if (productData.isEmpty()) {
            builder.append("Nothing bought");
        } else {
            builder.append(productData);
        }
        return builder.toString();
    }
}
