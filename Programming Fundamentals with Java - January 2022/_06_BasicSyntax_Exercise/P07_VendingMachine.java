package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        double sum = 0;
        while (!command.equals("Start")) {
            double money = Double.parseDouble(command);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            command = scanner.nextLine();
        }

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            double currentPrice = 0;
            if (product.equals("Nuts")) {
                currentPrice = 2;
            } else if (product.equals("Water")) {
                currentPrice = 0.7;
            } else if (product.equals("Crisps")) {
                currentPrice = 1.5;
            } else if (product.equals("Soda")) {
                currentPrice = 0.8;
            } else if (product.equals("Coke")) {
                currentPrice = 1.0;
            } else {
                System.out.println("Invalid product");
                product = scanner.nextLine();
                continue;
            }
            if (sum - currentPrice < 0) {
                System.out.println("Sorry, not enough money");
            } else {
                sum -= currentPrice;
                System.out.printf("Purchased %s%n", product);
            }
            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f%n", sum);
    }
}
