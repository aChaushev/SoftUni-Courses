package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E04GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstPlayer = scanner.nextLine();
        String secondPlayer = scanner.nextLine();
        String input = scanner.nextLine();

        int firstPPoints = 0;
        int secondPPoints = 0;
        String winner = "";
        int winnerPoints = 0;
        while (!input.equals("End of game")) {
            int firstPCard = Integer.parseInt(input);
            int secondPCard = Integer.parseInt(scanner.nextLine());
            if (firstPCard > secondPCard) {
                firstPPoints += firstPCard - secondPCard;
            } else if (firstPCard < secondPCard) {
                secondPPoints += secondPCard - firstPCard;
            } else {
                int firstPCardR2 = Integer.parseInt(scanner.nextLine());
                int secondPCardR2 = Integer.parseInt(scanner.nextLine());
                if (firstPCardR2 > secondPCardR2) {
                    winner = firstPlayer;
                    winnerPoints = firstPPoints;
                } else if (firstPCardR2 < secondPCardR2) {
                    winner = secondPlayer;
                    winnerPoints = secondPPoints;
                }
                break;
            }
            input = scanner.nextLine();
        }

        if (!winner.equals("")) {
            System.out.printf("Number wars!%n%s is winner with %d points", winner, winnerPoints);
        } else {
            System.out.printf("%s has %d points%n%s has %d points", firstPlayer, firstPPoints, secondPlayer, secondPPoints);
        }
    }
}
