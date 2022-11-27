package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E05_SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double trunkCapacity = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        int suitcaseCnt = 0;
        boolean noMoreSpace = false;
        while (!input.equals("End")) {
            double suitcaseVolume = Double.parseDouble(input);
            suitcaseCnt++;
            if (suitcaseCnt % 3 == 0) {
                suitcaseVolume *= 1.1;
            }
            if ((trunkCapacity - suitcaseVolume) >= 0) {
                trunkCapacity -= suitcaseVolume;
            } else {
                suitcaseCnt--;
                noMoreSpace = true;
                break;
            }
            input = scanner.nextLine();
        }
        if (noMoreSpace) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", suitcaseCnt);
    }
}
