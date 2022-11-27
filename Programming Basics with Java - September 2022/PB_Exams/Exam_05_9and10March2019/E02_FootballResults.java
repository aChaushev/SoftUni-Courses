package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E02_FootballResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int won = 0;
        int drawn = 0;
        int lost = 0;
        for (int i = 1; i <= 3; i++) {
            String currentResult = scanner.nextLine();
            if (currentResult.charAt(0) > currentResult.charAt(2)) {
                won++;
            } else if (currentResult.charAt(0) == currentResult.charAt(2)) {
                drawn++;
            } else if (currentResult.charAt(0) < currentResult.charAt(2)) {
                lost++;
            }
        }

        System.out.printf("Team won %d games.%n", won);
        System.out.printf("Team lost %d games.%n", lost);
        System.out.printf("Drawn games: %d", drawn);
    }
}
