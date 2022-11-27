package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E04_FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double foodAmount = Double.parseDouble(scanner.nextLine());

        double dogsFoodEaten = 0;
        double catsFoodEaten = 0;
        double biscuits = 0;
        for (int i = 1; i <= days; i++) {
            int dogsFood = Integer.parseInt(scanner.nextLine());
            dogsFoodEaten += dogsFood;
            int catsFood = Integer.parseInt(scanner.nextLine());
            catsFoodEaten += catsFood;
            if (i % 3 == 0) {
                biscuits += (dogsFood + catsFood) * 0.1;
            }
        }
        double totalFoodEaten = dogsFoodEaten + catsFoodEaten;
        System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(biscuits));
        System.out.printf("%.2f%% of the food has been eaten.%n", totalFoodEaten / foodAmount * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", dogsFoodEaten / totalFoodEaten * 100);
        System.out.printf("%.2f%% eaten from the cat.", catsFoodEaten / totalFoodEaten * 100);
    }
}
