package InterfacesAndAbstractionExercise.BirthdayCelebrations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> personBirthdayMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] inputData = input.split("\\s+");

            if (inputData.length == 5) {
                String citizenBirthdayInput = inputData[4];
                String[] citizenBirthday = citizenBirthdayInput.split("/");
                int citizenBirthdayYear = Integer.parseInt(citizenBirthday[2]);
                personBirthdayMap.put(citizenBirthdayInput, citizenBirthdayYear);
            } else if (inputData.length == 3) {
                if (inputData[0].equals("Pet")) {
                    String petBirthdayInput = inputData[2];
                    String[] petBirthday = petBirthdayInput.split("/");
                    int petBirthdayYear = Integer.parseInt(petBirthday[2]);
                    personBirthdayMap.put(petBirthdayInput, petBirthdayYear);
                } else {
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }

        int yearToFind = Integer.parseInt(scanner.nextLine());

        List<String> foundedYears = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : personBirthdayMap.entrySet()) {
            for (Integer value : personBirthdayMap.values()) {
                if (entry.getValue().equals(yearToFind)) {
                    foundedYears.add(entry.getKey());
                    break;
                }
            }
        }

        if (foundedYears.isEmpty()) {
            System.out.println("<no output>");
        } else {
            for (String year : foundedYears) {
                System.out.println(year);
            }
        }
    }
}
