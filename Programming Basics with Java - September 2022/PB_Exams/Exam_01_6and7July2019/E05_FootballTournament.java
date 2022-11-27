package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E05_FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Името на футболния отбор, за който водим статистика - текст
        //•	Броя изиграни срещи през настоящия сезон - цяло число в интервала [0… 100]
        // За всяка изиграна среща се прочита отделен ред:
        //o	Резултатът от изиграната среща в един от горепосочените формати – символ с възможности 'W', 'D' и 'L'
        String footballTeam = scanner.nextLine();
        int gamesPlayed = Integer.parseInt(scanner.nextLine());

        int w = 0;
        int d = 0;
        int l = 0;
        int pointsSum = 0;
        for (int i = 1; i <= gamesPlayed; i++) {
            char result = scanner.nextLine().charAt(0);
            switch (result) {
                case 'W':
                    w++;
                    pointsSum += 3;
                    break;
                case 'D':
                    d++;
                    pointsSum += 1;
                    break;
                case 'L':
                    l++;
                    break;
            }
        }
        if (gamesPlayed == 0) {
            System.out.printf("%s hasn't played any games during this season.", footballTeam);
        } else {
            System.out.printf("%s has won %d points during this season.%n", footballTeam, pointsSum);
            System.out.println("Total stats:");
            System.out.printf("## W: %d%n", w);
            System.out.printf("## D: %d%n", d);
            System.out.printf("## L: %d%n", l);
            System.out.printf("Win rate: %.2f%%", w * 1.0 / gamesPlayed * 100);
        }
    }
}
