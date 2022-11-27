package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E04_Eggs_Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPlayerEggs = Integer.parseInt(scanner.nextLine());
        int secondPlayerEggs = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            switch (input) {
                case "one":
                    secondPlayerEggs--;
                    break;
                case "two":
                    firstPlayerEggs--;
                    break;
            }
            if (firstPlayerEggs == 0 || secondPlayerEggs == 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (firstPlayerEggs == 0) {
            System.out.printf("Player one is out of eggs. Player two has %d eggs left.", secondPlayerEggs);
        } else if (secondPlayerEggs == 0) {
            System.out.printf("Player two is out of eggs. Player one has %d eggs left.", firstPlayerEggs);
        } else {
            System.out.printf("Player one has %d eggs left.%n", firstPlayerEggs);
            System.out.printf("Player two has %d eggs left.%n", secondPlayerEggs);
        }
    }
}
