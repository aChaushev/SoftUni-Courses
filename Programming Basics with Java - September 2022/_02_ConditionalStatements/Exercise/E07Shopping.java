package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double petersBudget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ramMemory = Integer.parseInt(scanner.nextLine());

        double videoCardCost = 250;
        double processorsCost = (videoCards * videoCardCost) * 0.35;
        double ramMemoryCost = (videoCards * videoCardCost) * 0.10;

        double totalCost = (videoCards * videoCardCost) + (processors * processorsCost) + (ramMemory * ramMemoryCost);

        if (videoCards > processors) {
            totalCost = totalCost * 0.85;
        }

        if (petersBudget >= totalCost) {
            System.out.printf("You have %.2f leva left!", petersBudget - totalCost);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", totalCost - petersBudget);
        }
    }
}
