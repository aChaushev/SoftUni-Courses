package _10_InterfacesAndAbstraction_Exercise._05_Тelephony;

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
        //no digits
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (hasDigits(url)) {
                sb.append("Invalid URL!")
                        .append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!%n", url));
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        //only digits
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (hasOnlyDigits(number)) {
                sb.append(String.format("Calling... %s%n", number));
            } else {
                sb.append("Invalid number!")
                        .append(System.lineSeparator());

            }
        }
        return sb.toString().trim();
    }

    private boolean hasDigits(String url) {
        for (char singleChar : url.toCharArray()) {
            if (Character.isDigit(singleChar)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasOnlyDigits(String url) {
        for (char singleChar : url.toCharArray()) {
            if (!Character.isDigit(singleChar)) {
                return false;
            }
        }
        return true;
    }
}
