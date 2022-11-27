package PB_Exams.Exam_08_28and29March2020;

import java.util.Scanner;

public class E04_TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupNum = Integer.parseInt(scanner.nextLine());

        int allPeople = 0;
        int musala = 0;
        int monblan = 0;
        int kalimandzharo = 0;
        int k2 = 0;
        int everest = 0;
        for (int i = 1; i <= groupNum; i++) {
            int peopleInGroup = Integer.parseInt(scanner.nextLine());
            allPeople += peopleInGroup;
            if (peopleInGroup <= 5) {
                musala += peopleInGroup;
            } else if (peopleInGroup <= 12) {
                monblan += peopleInGroup;
            } else if (peopleInGroup <= 25) {
                kalimandzharo += peopleInGroup;
            } else if (peopleInGroup <= 40) {
                k2 += peopleInGroup;
            } else {
                everest += peopleInGroup;
            }
        }
        System.out.printf("%.2f%%%n", musala * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", monblan * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", kalimandzharo * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", k2 * 1.0 / allPeople * 100);
        System.out.printf("%.2f%%%n", everest * 1.0 / allPeople * 100);
    }
}
