package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wRecordTime = Double.parseDouble(scanner.nextLine());
        double wRecordDistance = Double.parseDouble(scanner.nextLine());
        double swimSpeed = Double.parseDouble(scanner.nextLine());

        double delay = Math.floor(wRecordDistance / 15) * 12.5;
        double ivanTime = (swimSpeed * wRecordDistance) + delay;

        if (ivanTime < wRecordTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", ivanTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", ivanTime - wRecordTime);
        }
    }
}
