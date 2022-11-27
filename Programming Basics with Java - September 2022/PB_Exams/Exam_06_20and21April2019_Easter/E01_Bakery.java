package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E01_Bakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double flourPrice = Double.parseDouble(scanner.nextLine());
        double floutAmountKg = Double.parseDouble(scanner.nextLine());
        double sugarAmountKg = Double.parseDouble(scanner.nextLine());
        int eggsCnt = Integer.parseInt(scanner.nextLine());
        int yeastPackages = Integer.parseInt(scanner.nextLine());

        double sugarPrice = flourPrice * 0.75;
        double eggsPrice = flourPrice * 1.1;
        double yeastPrice = sugarPrice * 0.2;

        double totalSum = floutAmountKg * flourPrice + sugarAmountKg * sugarPrice + eggsCnt * eggsPrice + yeastPackages * yeastPrice;
        System.out.printf("%.2f", totalSum);
    }
}
