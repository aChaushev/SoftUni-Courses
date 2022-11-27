package _01_FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class E07HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double wallsArea = 2 * (x * x) + 2 * (x * y) - (1.2 * 2) - 2 * (1.5 * 1.5);
        double roofArea = 2 * (x * y) + x * h;
        double greenPaint = wallsArea / 3.4;
        double redPaint = roofArea / 4.3;
        System.out.printf("%.2f %n", greenPaint);
        System.out.printf("%.2f", redPaint);
    }
}
