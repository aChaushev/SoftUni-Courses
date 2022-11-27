package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E06_TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tournamentDays = Integer.parseInt(scanner.nextLine());

        double charitySum = 0;
        int winDays = 0;
        for (int days = 1; days <= tournamentDays; days++) {
            String input = scanner.nextLine();
            double charityDailySum = 0;
            int wins = 0;
            int losses = 0;
            while (!input.equals("Finish")) {
                boolean win = scanner.nextLine().equals("win");
                if (win) {
                    wins++;
                    charityDailySum += 20;
                } else {
                    losses++;
                }
                input = scanner.nextLine();
            }
            if (wins > losses) {
                winDays++;
                charityDailySum *= 1.1;
            }
            charitySum += charityDailySum;
        }

        if (winDays > (tournamentDays - winDays)) {
            charitySum *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", charitySum);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", charitySum);
        }
    }
}
