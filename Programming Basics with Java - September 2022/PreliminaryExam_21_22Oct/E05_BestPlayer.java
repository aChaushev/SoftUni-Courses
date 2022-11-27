package PreliminaryExam_21_22Oct;

import java.util.Scanner;

public class E05_BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int maxGoals = -1;
        String bestPlayer = "";
        boolean hat_trick = false;
        while (!input.equals("END")) {
            String player = input;
            int goals = Integer.parseInt(scanner.nextLine());
            if (maxGoals < goals) {
                maxGoals = goals;
                bestPlayer = player;
            }
            if (goals >= 3) {
                hat_trick = true;
            }
            if (goals >= 10) {
                break;
            }
            input = scanner.nextLine();
        }

        System.out.printf("%s is the best player!%n", bestPlayer);
        if (hat_trick) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", maxGoals);
        } else {
            System.out.printf("He has scored %d goals.", maxGoals);
        }
    }
}