package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E02_SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        boolean cold = 10 <= degrees && degrees <= 18;
        boolean mid = 18 < degrees && degrees <= 24;
        boolean hot = 25 <= degrees;

        String outfit = "";
        String shoes = "";

        if (timeOfDay.equals("Morning")) {
            if (cold) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if (mid) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (hot) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            }
        } else if (timeOfDay.equals("Afternoon")) {
            if (cold) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (mid) {
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else if (hot) {
                outfit = "Swim Suit";
                shoes = "Barefoot";
            }
        } else if (timeOfDay.equals("Evening")) {
            if (cold) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (mid) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if (hot) {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }
        System.out.printf("It's %d degrees, get your %s and %s.", degrees, outfit, shoes);
    }
}
