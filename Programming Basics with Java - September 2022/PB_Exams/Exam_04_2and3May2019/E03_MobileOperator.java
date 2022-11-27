package PB_Exams.Exam_04_2and3May2019;

import java.util.Scanner;

public class E03_MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String contractDuration = scanner.nextLine();
        String contractType = scanner.nextLine();
        boolean mobileInternet = scanner.nextLine().equals("yes");
        int monthsToPay = Integer.parseInt(scanner.nextLine());

        double sumPerMonth = 0;
        if (contractType.equals("Small")) {
            if (contractDuration.equals("one")) {
                sumPerMonth = 9.98;
            } else if (contractDuration.equals("two")) {
                sumPerMonth = 8.58;
            }
        } else if (contractType.equals("Middle")) {
            if (contractDuration.equals("one")) {
                sumPerMonth = 18.99;
            } else if (contractDuration.equals("two")) {
                sumPerMonth = 17.09;
            }
        } else if (contractType.equals("Large")) {
            if (contractDuration.equals("one")) {
                sumPerMonth = 25.98;
            } else if (contractDuration.equals("two")) {
                sumPerMonth = 23.59;
            }
        } else if (contractType.equals("ExtraLarge")) {
            if (contractDuration.equals("one")) {
                sumPerMonth = 35.99;
            } else if (contractDuration.equals("two")) {
                sumPerMonth = 31.79;
            }
        }

        if (mobileInternet) {
            if (sumPerMonth <= 10) {
                sumPerMonth += 5.50;
            } else if (sumPerMonth <= 30) {
                sumPerMonth += 4.35;
            } else {
                sumPerMonth += 3.85;
            }
        }

        double totalSum = sumPerMonth * monthsToPay;
        if (contractDuration.equals("two")) {
            totalSum -= totalSum * 0.0375;
        }
        System.out.printf("%.2f lv.", totalSum);
    }
}
