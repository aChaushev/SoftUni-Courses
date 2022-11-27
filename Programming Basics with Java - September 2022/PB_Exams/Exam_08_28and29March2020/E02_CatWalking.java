package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E02_CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesOfWalking = Integer.parseInt(scanner.nextLine());
        int numOfWalks = Integer.parseInt(scanner.nextLine());
        int caloriesPerDay = Integer.parseInt(scanner.nextLine());

        double targetCalories = caloriesPerDay / 2.0;
        double caloriesBurned = minutesOfWalking * numOfWalks * 5;
        if (caloriesBurned >= targetCalories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", caloriesBurned);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", caloriesBurned);
        }
    }
}
