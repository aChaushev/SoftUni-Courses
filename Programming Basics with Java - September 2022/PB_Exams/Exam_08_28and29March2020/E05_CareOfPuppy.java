package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E05_CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogFoodBoughtKg = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int allFoodEatenG = 0;
        while (!input.equals("Adopted")) {
            int foodEatenG = Integer.parseInt(input);
            allFoodEatenG += foodEatenG;
            input = scanner.nextLine();
        }
        int allFoodBoughG = dogFoodBoughtKg * 1000;
        int diff = Math.abs(allFoodBoughG - allFoodEatenG);
        if (allFoodBoughG >= allFoodEatenG) {
            System.out.printf("Food is enough! Leftovers: %d grams.", diff);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", diff);
        }
    }
}
