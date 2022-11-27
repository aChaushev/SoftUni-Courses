package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E05_PCGameShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Брой продадени игри- n - цяло положително число в интервала [1… 100]
        //За следващите n реда се чете по един ред:
        //o	Име на игра - текст
        int gamesSold = Integer.parseInt(scanner.nextLine());

        int hearthstoneCount = 0;
        int forniteCount = 0;
        int overwatchCount = 0;
        int othersCount = 0;
        for (int i = 1; i <= gamesSold; i++) {
            String game = scanner.nextLine();
            if (game.equals("Hearthstone")) {
                hearthstoneCount++;
            } else if (game.equals("Fornite")) {
                forniteCount++;
            } else if (game.equals("Overwatch")) {
                overwatchCount++;
            } else {
                othersCount++;
            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", hearthstoneCount * 1.0 / gamesSold * 100);
        System.out.printf("Fornite - %.2f%%%n", forniteCount * 1.0 / gamesSold * 100);
        System.out.printf("Overwatch - %.2f%%%n", overwatchCount * 1.0 / gamesSold * 100);
        System.out.printf("Others - %.2f%%%n", othersCount * 1.0 / gamesSold * 100);
    }
}
