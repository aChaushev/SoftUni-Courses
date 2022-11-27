package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E02_MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int shootingTime = Integer.parseInt(scanner.nextLine());
        int sceneNum = Integer.parseInt(scanner.nextLine());
        int oneSceneTime = Integer.parseInt(scanner.nextLine());

        double totalTime = sceneNum * oneSceneTime + shootingTime * 0.15;
        double diff = Math.round(Math.abs(shootingTime - totalTime));
        if (shootingTime >= totalTime) {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", diff);
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", diff);
        }
    }
}
