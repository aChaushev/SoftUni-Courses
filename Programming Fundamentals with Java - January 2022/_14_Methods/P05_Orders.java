package _14_Methods;

import java.util.Scanner;

public class P05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        switch (product) {
            case "coffee":
                coffeePrice(1.5, quantity);
                break;
            case "water":
                waterPrice(1, quantity);
                break;
            case "coke":
                cokePrice(1.4, quantity);
                break;
            case "snacks":
                snacksPrice(2, quantity);
                break;
        }
    }

    public static void coffeePrice(double singlePrice, int quantity) {
        double totalPrice = singlePrice * quantity;
        System.out.printf("%.2f",totalPrice);
    }

    public static void waterPrice(double singlePrice, int quantity) {
        double totalPrice = singlePrice * quantity;
        System.out.printf("%.2f",totalPrice);
    }

    public static void cokePrice(double singlePrice, int quantity) {
        double totalPrice = singlePrice * quantity;
        System.out.printf("%.2f",totalPrice);
    }

    public static void snacksPrice(double singlePrice, int quantity) {
        double totalPrice = singlePrice * quantity;
        System.out.printf("%.2f",totalPrice);
    }
}
