package _05_WhileLoop.Lab;

import java.util.Scanner;

public class P05_AccountBalance_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;
        while (!input.equals("NoMoreMoney")) {
            double currentNum = Double.parseDouble(input);
            if (currentNum < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", currentNum);
            sum += currentNum;
            input = scanner.nextLine();
        }
            System.out.printf("Total: %.2f", sum);


    }
}
