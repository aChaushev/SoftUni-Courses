package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E05_Bake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadsCnt = Integer.parseInt(scanner.nextLine());

        int totalSugarAmount = 0;
        int totalFlourAmount = 0;
        int maxSugarAmount = Integer.MIN_VALUE;
        int maxFlourAmount = Integer.MIN_VALUE;
        for (int i = 1; i <= easterBreadsCnt; i++) {
            int sugarAmount = Integer.parseInt(scanner.nextLine());
            int flourAmount = Integer.parseInt(scanner.nextLine());
            totalSugarAmount += sugarAmount;
            totalFlourAmount += flourAmount;
            if (maxSugarAmount < sugarAmount) {
                maxSugarAmount = sugarAmount;
            }
            if (maxFlourAmount < flourAmount) {
                maxFlourAmount = flourAmount;
            }
        }
        double sugarPackages = Math.ceil(totalSugarAmount * 1.0 / 950);
        double flourPackages = Math.ceil(totalFlourAmount * 1.0 / 750);

        System.out.printf("Sugar: %.0f%n",sugarPackages);
        System.out.printf("Flour: %.0f%n",flourPackages);
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.",maxFlourAmount,maxSugarAmount);
    }
}
