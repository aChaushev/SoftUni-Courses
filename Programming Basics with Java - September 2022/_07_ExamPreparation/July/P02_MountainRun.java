package _07_ExamPreparation.July;

import java.util.Scanner;

public class P02_MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Рекордът в секунди – реално число в интервала [0.00 … 100000.00]
        //2. Разстоянието в метри – реално число в интервала [0.00 … 100000.00]
        //3. Времето в секунди, за което изкачва 1 м. – реално число в интервала [0.00 … 1000.00]

        double recordSec = Double.parseDouble(scanner.nextLine());
        double distanceMeters = Double.parseDouble(scanner.nextLine());
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        double delay = Math.floor(distanceMeters / 50) * 30;
        double georgiTime = secondsPerMeter * distanceMeters + delay;

        double diff = Math.abs(recordSec - georgiTime);

        if (georgiTime < recordSec) {
            System.out.printf("Yes! The new record is %.2f seconds.", georgiTime);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", diff);
        }
    }
}
