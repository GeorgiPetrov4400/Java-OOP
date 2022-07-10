package InterfacesAndAbstractionLab.BorderControl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> citizenAndRobotIdMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] inputData = input.split("\\s+");
            if (inputData.length == 2) {
                String robotName = inputData[0];
                String robotId = inputData[1];
                citizenAndRobotIdMap.put(robotName, robotId);
            } else if (inputData.length == 3) {
                String citizenName = inputData[0];
                String citizenId = inputData[2];
                citizenAndRobotIdMap.put(citizenName, citizenId);
            }

            input = scanner.nextLine();
        }

        String fakeIdToRemove = scanner.nextLine();

        for (String value : citizenAndRobotIdMap.values()) {
            if (value.endsWith(fakeIdToRemove)) {
                System.out.println(value);
            }
        }
    }
}
