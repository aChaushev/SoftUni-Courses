package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E04_Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();
        String input = scanner.nextLine();

        int totalPoints = 301;
        int successfulShot = 0;
        int missedShot = 0;
        while (!input.equals("Retire")) {
            int points = Integer.parseInt(scanner.nextLine());
            if (input.equals("Double")) {
                points *= 2;
            } else if (input.equals("Triple")) {
                points *= 3;
            }
            if (totalPoints - points >= 0) {
                successfulShot++;
                totalPoints -= points;
            } else {
                missedShot++;
            }
            if (totalPoints == 0) {
                break;
            }
            input = scanner.nextLine();
        }

        if (totalPoints == 0) {
            System.out.printf("%s won the leg with %d shots.", playerName, successfulShot);
        } else {
            System.out.printf("%s retired after %d unsuccessful shots.", playerName, missedShot);
        }
    }
}
