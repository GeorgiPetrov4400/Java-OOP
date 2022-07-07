
package WorkingWithAbstractionExercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] itemAndQuantityInput = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bagWithItems = new LinkedHashMap<>();

        long gold = 0;
        long gems = 0;
        long money = 0;

        for (int i = 0; i < itemAndQuantityInput.length; i += 2) {
            String itemName = itemAndQuantityInput[i];
            long itemAmount = Long.parseLong(itemAndQuantityInput[i + 1]);

            String item = "";

            if (itemName.length() == 3) {
                item = "Cash";
            } else if (itemName.toLowerCase().endsWith("gem")) {
                item = "Gem";
            } else if (itemName.toLowerCase().equals("gold")) {
                item = "Gold";
            }

            if (item.equals("")) {
                continue;
            } else if (bagCapacity < bagWithItems.values().stream().map(Map::values)
                    .flatMap(Collection::stream).mapToLong(e -> e).sum() + itemAmount) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bagWithItems.containsKey(item)) {
                        if (bagWithItems.containsKey("Gold")) {
                            if (itemAmount > bagWithItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagWithItems.get(item).values().stream()
                            .mapToLong(e -> e).sum() + itemAmount > bagWithItems.get("Gold").values().stream().mapToLong(e -> e)
                            .sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bagWithItems.containsKey(item)) {
                        if (bagWithItems.containsKey("Gem")) {
                            if (itemAmount > bagWithItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagWithItems.get(item).values().stream()
                            .mapToLong(e -> e).sum() + itemAmount > bagWithItems.get("Gem").values().stream().mapToLong(e -> e)
                            .sum()) {
                        continue;
                    }
                    break;
            }

            if (!bagWithItems.containsKey(item)) {
                bagWithItems.put((item), new LinkedHashMap<>());
            }

            if (!bagWithItems.get(item).containsKey(itemName)) {
                bagWithItems.get(item).put(itemName, 0L);
            }


            bagWithItems.get(item).put(itemName, bagWithItems.get(item).get(itemName) + itemAmount);
            if (item.equals("Gold")) {
                gold += itemAmount;
            } else if (item.equals("Gem")) {
                gems += itemAmount;
            } else if (item.equals("Cash")) {
                money += itemAmount;
            }
        }

        for (var entry : bagWithItems.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}