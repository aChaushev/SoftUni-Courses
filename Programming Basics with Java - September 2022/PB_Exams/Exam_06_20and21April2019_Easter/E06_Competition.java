package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E06_Competition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadCnt = Integer.parseInt(scanner.nextLine());
        int maxBakerPoints = -1;
        String bestBaker = "";
        for (int i = 1; i <= easterBreadCnt; i++) {
            String bakersName = scanner.nextLine();
            String input = scanner.nextLine();
            int bakersPoints = 0;
            while ((!input.equals("Stop"))) {
                int points = Integer.parseInt(input);
                bakersPoints += points;
                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", bakersName, bakersPoints);
            if (maxBakerPoints < bakersPoints) {
                maxBakerPoints = bakersPoints;
                bestBaker = bakersName;
                System.out.printf("%s is the new number 1!%n", bakersName);
            }
        }
        System.out.printf("%s won competition with %d points!", bestBaker, maxBakerPoints);
    }
}
