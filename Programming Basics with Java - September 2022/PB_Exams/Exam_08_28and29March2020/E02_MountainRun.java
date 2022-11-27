package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E02_MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSec = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double secondsPerMeter = Double.parseDouble(scanner.nextLine());

        double runnerTime = secondsPerMeter * distanceInMeters + Math.floor(distanceInMeters / 50) * 30;
        if (runnerTime < recordInSec) {
            System.out.printf("Yes! The new record is %.2f seconds.", runnerTime);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", runnerTime - recordInSec);
        }
    }
}
