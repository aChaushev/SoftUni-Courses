package PB_Exams.Exam_07_18and19July2020;

import java.util.Scanner;

public class E04_Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ballsNum = Integer.parseInt(scanner.nextLine());

        double points = 0;
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int others = 0;
        for (int i = 1; i <= ballsNum; i++) {
            String color = scanner.nextLine();
            switch (color) {
                case "red":
                    red++;
                    points += 5;
                    break;
                case "orange":
                    orange++;
                    points += 10;
                    break;
                case "yellow":
                    yellow++;
                    points += 15;
                    break;
                case "white":
                    white++;
                    points += 20;
                    break;
                case "black":
                    black++;
                    points = Math.floor(points / 2);
                    break;
                default:
                    others++;
                    break;
            }
        }
        System.out.printf("Total points: %.0f%n", points);
        System.out.printf("Red balls: %d%n", red);
        System.out.printf("Orange balls: %d%n", orange);
        System.out.printf("Yellow balls: %d%n", yellow);
        System.out.printf("White balls: %d%n", white);
        System.out.printf("Other colors picked: %d%n", others);
        System.out.printf("Divides from black balls: %d", black);
    }
}
