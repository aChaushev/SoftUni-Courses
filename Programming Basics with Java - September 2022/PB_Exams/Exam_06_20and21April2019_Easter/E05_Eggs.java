package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E05_Eggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int coloredEggs = Integer.parseInt(scanner.nextLine());
        int redEggs = 0;
        int orangeEggs = 0;
        int blueEggs = 0;
        int greenEggs = 0;
        int maxEggs = Integer.MIN_VALUE;
        String maxEggsColor = "";
        for (int i = 1; i <= coloredEggs; i++) {
            String color = scanner.nextLine();
            switch (color) {
                case "red":
                    redEggs++;
                    break;
                case "orange":
                    orangeEggs++;
                    break;
                case "blue":
                    blueEggs++;
                    break;
                case "green":
                    greenEggs++;
                    break;
            }
        }
        if (maxEggs < redEggs) {
            maxEggs = redEggs;
            maxEggsColor = "red";
        }
        if (maxEggs < orangeEggs) {
            maxEggs = orangeEggs;
            maxEggsColor = "orange";
        }
        if (maxEggs < blueEggs) {
            maxEggs = blueEggs;
            maxEggsColor = "blue";
        }
        if (maxEggs < greenEggs) {
            maxEggs = greenEggs;
            maxEggsColor = "green";
        }
        System.out.printf("Red eggs: %d%n", redEggs);
        System.out.printf("Orange eggs: %d%n", orangeEggs);
        System.out.printf("Blue eggs: %d%n", blueEggs);
        System.out.printf("Green eggs: %d%n", greenEggs);
        System.out.printf("Max eggs: %d -> %s", maxEggs, maxEggsColor);
    }
}
