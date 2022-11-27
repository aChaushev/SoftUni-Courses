package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E03_Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vineyardAreaX = Integer.parseInt(scanner.nextLine());
        double grapesSqMeterY = Double.parseDouble(scanner.nextLine());
        int wineLitersSaleZ = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double areaForWine = vineyardAreaX * 0.4;
        double grapesKg = areaForWine * grapesSqMeterY;
        double wineLiters = grapesKg / 2.5;

        double wineDiff = Math.abs(wineLitersSaleZ - wineLiters);
        if (wineLiters < wineLitersSaleZ) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineDiff));

        } else {
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n",Math.floor(wineLiters));
            System.out.printf("%.0f liters left -> %.0f liters per person.",
                    Math.ceil(wineDiff),Math.ceil(wineDiff/workers));
        }
    }
}
