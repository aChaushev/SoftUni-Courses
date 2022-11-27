package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E02_Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetMin = Integer.parseInt(scanner.nextLine());
        int targetSec = Integer.parseInt(scanner.nextLine());
        double chuteLength = Double.parseDouble(scanner.nextLine());
        int secPer100Meters = Integer.parseInt(scanner.nextLine());

        int targetTimeSec = targetSec + targetMin * 60;
        double reducedTimeSec = (chuteLength / 120) * 2.5;
        double racerTimeSec = chuteLength / 100 * secPer100Meters - reducedTimeSec;

        if (racerTimeSec <= targetTimeSec) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", racerTimeSec);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", racerTimeSec - targetTimeSec);
        }
    }
}
