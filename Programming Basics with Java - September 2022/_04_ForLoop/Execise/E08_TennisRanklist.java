package _04_ForLoop.Execise;

import java.util.Scanner;

public class E08_TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); // Брой турнири
        int initialPoints = Integer.parseInt(scanner.nextLine()); // Начален брой точки

        int wins = 0;
        int points = 0;
        for (int i = 1; i <= n; i++) {
            String stage = scanner.nextLine();
            if (stage.equals("W")) {
                points += 2000;
                wins++;
            } else if (stage.equals("F")) {
                points += 1200;
            } else if (stage.equals("SF")) {
                points += 720;
            }
        }
        int totalPoints = initialPoints + points;
        double midPoints = Math.floor(points * 1.0 / n);
        double winPercent = wins * 1.0 / n * 100;
        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %.0f%n", midPoints);
        System.out.printf("%.2f%%", winPercent);
    }
}
