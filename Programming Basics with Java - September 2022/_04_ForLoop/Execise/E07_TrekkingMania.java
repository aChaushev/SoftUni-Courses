package _04_ForLoop.Execise;

import java.util.Scanner;

public class E07_TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	На първия ред – броя на групите от катерачи – цяло число в интервала [1...1000]
        //•	За всяка една група на отделен ред – броя на хората в групата – цяло число в интервала [1...1000]

        int n = Integer.parseInt(scanner.nextLine()); // броя на групите

        //•	Група до 5 човека – изкачват Мусала
        //•	Група от 6 до 12 човека – изкачват Монблан
        //•	Група от 13 до 25 човека – изкачват Килиманджаро
        //•	Група от 26 до 40 човека –  изкачват К2
        //•	Група от 41 или повече човека – изкачват Еверест

        int totalPeople = 0;
        int g1 = 0;
        int g2 = 0;
        int g3 = 0;
        int g4 = 0;
        int g5 = 0;
        for (int i = 1; i <= n; i++) {
            int peopleNum = Integer.parseInt(scanner.nextLine());
            totalPeople += peopleNum;
            if (peopleNum <= 5) {
                g1 += peopleNum;
            } else if (peopleNum <= 12) {
                g2 += peopleNum;
            } else if (peopleNum <= 25) {
                g3 += peopleNum;
            } else if (peopleNum <= 40) {
                g4 += peopleNum;
            } else {
                g5 += peopleNum;
            }
        }
        System.out.printf("%.2f%%%n", g1 * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%%n", g2 * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%%n", g3 * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%%n", g4 * 1.0 / totalPeople * 100);
        System.out.printf("%.2f%%%n", g5 * 1.0 / totalPeople * 100);
    }
}
