package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E06_BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int t1Win = 0;
        int t1Lost = 0;
        int allGames = 0;
        while (!input.equals("End of tournaments")) {
            String currentTournament = input;
            int gamesNum = Integer.parseInt(scanner.nextLine());
            allGames += gamesNum;
            for (int i = 1; i <= gamesNum; i++) {
                int team1Points = Integer.parseInt(scanner.nextLine());
                int team2Points = Integer.parseInt(scanner.nextLine());
                int diff = Math.abs(team1Points - team2Points);
                if (team1Points > team2Points) {
                    t1Win++;
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", i, currentTournament, diff);
                } else if (team1Points < team2Points) {
                    t1Lost++;
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, currentTournament, diff);
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("%.2f%% matches win%n", t1Win * 1.0 / allGames * 100);
        System.out.printf("%.2f%% matches lost%n", t1Lost * 1.0 / allGames * 100);
    }
}
