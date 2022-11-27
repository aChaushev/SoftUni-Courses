package _06_NestedLoops.Lab;

import java.util.Scanner;

public class P05_Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String destination = input;
            double targetBudget = Double.parseDouble(scanner.nextLine());

            double anasSum = 0;
            while (anasSum < targetBudget) {
                double money = Double.parseDouble(scanner.nextLine());
                anasSum += money;
            }
            System.out.printf("Going to %s!%n", destination);
            input = scanner.nextLine();
        }
    }
}

