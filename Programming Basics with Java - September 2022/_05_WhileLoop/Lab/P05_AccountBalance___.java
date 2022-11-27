package _05_WhileLoop.Lab;

import java.util.Scanner;

public class P05_AccountBalance___ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        double sum = 0;
        while (!inputLine.equals("NoMoreMoney")) {

            double currentNum = Double.parseDouble(inputLine);

            if (currentNum <= 0) {
                System.out.println("Invalid operation!");
                break;
            }

            sum += currentNum;

            System.out.printf("Increase: %.2f%n", currentNum);

            inputLine = scanner.nextLine();


        }
        System.out.printf("Total: %.2f", sum);
    }
}

