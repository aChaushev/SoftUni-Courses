package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E03_PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String eggSize = scanner.nextLine();
        String eggColor = scanner.nextLine();
        int eggBatchCnt = Integer.parseInt(scanner.nextLine());

        double eggBatchPrice = 0;
        if (eggSize.equals("Large")) {
            if (eggColor.equals("Red")) {
                eggBatchPrice = 16;
            } else if (eggColor.equals("Green")) {
                eggBatchPrice = 12;
            } else if (eggColor.equals("Yellow")) {
                eggBatchPrice = 9;
            }
        } else if (eggSize.equals("Medium")) {
            if (eggColor.equals("Red")) {
                eggBatchPrice = 13;
            } else if (eggColor.equals("Green")) {
                eggBatchPrice = 9;
            } else if (eggColor.equals("Yellow")) {
                eggBatchPrice = 7;
            }
        } else if (eggSize.equals("Small")) {
            if (eggColor.equals("Red")) {
                eggBatchPrice = 9;
            } else if (eggColor.equals("Green")) {
                eggBatchPrice = 8;
            } else if (eggColor.equals("Yellow")) {
                eggBatchPrice = 5;
            }
        }
        double totalIncome = (eggBatchCnt * eggBatchPrice) * 0.65;
        System.out.printf("%.2f leva.", totalIncome);
    }
}
