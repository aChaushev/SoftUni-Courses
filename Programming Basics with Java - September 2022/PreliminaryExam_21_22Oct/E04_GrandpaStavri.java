package PreliminaryExam_21_22Oct;

import java.util.Scanner;

public class E04_GrandpaStavri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysN = Integer.parseInt(scanner.nextLine());

        double amountSum = 0;
        double degreeSum = 0;
        for (int day = 1; day <= daysN; day++) {
            double brandyAmount = Double.parseDouble(scanner.nextLine());
            double drinkDegree = Double.parseDouble(scanner.nextLine());
            amountSum += brandyAmount;
            degreeSum += brandyAmount * drinkDegree;
        }
        double averageDegree = degreeSum / amountSum;
        System.out.printf("Liter: %.2f%n", amountSum);
        System.out.printf("Degrees: %.2f%n", averageDegree);
        if (averageDegree < 38) {
            System.out.println("Not good, you should baking!");
        } else if (averageDegree < 42) {
            System.out.println("Super!");
        } else {
            System.out.println("Dilution with distilled water!");
        }
    }
}
