package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E06_NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int maxPointsCnt = 0;
        String winner = "";
        while (!input.equals("Stop")) {
            int n = input.length();
            int currentPointsCnt = 0;
            for (int i = 0; i < n; i++) {
                int currentNum = Integer.parseInt(scanner.nextLine());
                char symbol = input.charAt(i);
                if (symbol == currentNum) {         //if (input.charAt(i) == currentNum) {
                    currentPointsCnt += 10;
                } else {
                    currentPointsCnt += 2;
                }
            }
            if (currentPointsCnt >= maxPointsCnt) {
                maxPointsCnt = currentPointsCnt;
                winner = input;
            }
            input = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winner, maxPointsCnt);
    }
}
