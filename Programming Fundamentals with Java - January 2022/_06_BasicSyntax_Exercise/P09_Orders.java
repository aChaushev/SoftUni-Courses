package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P09_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ordersCnt = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0;
        for (int i = 1; i <= ordersCnt; i++) {
            double capsulePrice = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsuleCnt = Integer.parseInt(scanner.nextLine());
            double orderPrice = days * capsuleCnt * capsulePrice;
            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);
            totalPrice += orderPrice;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
