package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E06_HighJump__ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetHeight = Integer.parseInt(scanner.nextLine());
        int currentTargetHeight = targetHeight - 30;
        int jumpsCnt = 0;
        int failedJumps = 0;
        while (failedJumps != 3) {
            int currentJump = Integer.parseInt(scanner.nextLine());
            jumpsCnt++;
            if (currentJump > currentTargetHeight) {
                if (currentTargetHeight >= targetHeight) {
                    break;
                }
                currentTargetHeight += 5;
                failedJumps = 0;
            } else {
                failedJumps++;
            }
        }
        if (failedJumps != 3) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", currentTargetHeight, jumpsCnt);
        } else {
            System.out.printf("Tihomir failed at %dcm after %d jumps.", currentTargetHeight, jumpsCnt);
        }
    }
}
