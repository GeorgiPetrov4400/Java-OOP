package InterfacesAndAbstractionExercise.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        boolean isValid = true;
        StringBuilder builder = new StringBuilder();

        for (String url : urls) {
            for (char c : url.toCharArray()) {
                if (c >= 48 && c <= 57) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                builder.append("Browsing: ").append(url).append("!").append("\n");
            } else {
                builder.append("Invalid URL!").append("\n");
                isValid = true;
            }
        }
        return builder.toString().trim();
    }

    @Override
    public String call() {
        boolean isValid = true;
        StringBuilder builder = new StringBuilder();

        for (String number : numbers) {
            for (char c : number.toCharArray()) {
                if (c < 48 || c > 57) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                builder.append("Calling... ").append(number).append("\n");
            } else {
                builder.append("Invalid number!").append("\n");
                isValid = true;
            }
        }
        return builder.toString().trim();
    }
}
