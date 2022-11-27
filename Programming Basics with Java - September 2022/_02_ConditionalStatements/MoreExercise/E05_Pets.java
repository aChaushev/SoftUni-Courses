package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E05_Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int allFoodKg = Integer.parseInt(scanner.nextLine());
        double dogFoodPerDay = Double.parseDouble(scanner.nextLine());
        double catFoodPerDay = Double.parseDouble(scanner.nextLine());
        double turtleFoodPerDayGrams = Double.parseDouble(scanner.nextLine());

        double turtleFoodPerDay = turtleFoodPerDayGrams / 1000;
        double totalAnimalFoodNeeded = dogFoodPerDay * days + catFoodPerDay * days + turtleFoodPerDay * days;
        double diff = Math.abs(allFoodKg - totalAnimalFoodNeeded);
        if (allFoodKg >= totalAnimalFoodNeeded) {
            System.out.printf("%.0f kilos of food left.", Math.floor(diff));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(diff));
        }
    }
}
