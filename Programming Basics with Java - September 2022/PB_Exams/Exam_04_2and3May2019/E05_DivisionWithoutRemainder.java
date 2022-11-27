package PB_Exams.Exam_04_2and3May2019;

import java.util.Scanner;

public class E05_DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int p1Cnt = 0;
        int p2Cnt = 0;
        int p3Cnt = 0;
        for (int i = 1; i <= n; i++) {
            int digit = Integer.parseInt(scanner.nextLine());
            if (digit % 2 == 0) {
                p1Cnt++;
            }
            if (digit % 3 == 0) {
                p2Cnt++;
            }
            if (digit % 4 == 0) {
                p3Cnt++;
            }
        }
        System.out.printf("%.2f%%%n", p1Cnt * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p2Cnt * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p3Cnt * 1.0 / n * 100);
    }
}
