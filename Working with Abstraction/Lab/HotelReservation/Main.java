package WorkingWithAbstractionLab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season currentSeason = Season.parse(input[2]);
        DiscountType discountType = DiscountType.parse(input[3]);

        PriceCalculator calculator = new PriceCalculator(pricePerDay, days, currentSeason, discountType);
        System.out.printf("%.2f", calculator.calculatePrice());
    }
}
