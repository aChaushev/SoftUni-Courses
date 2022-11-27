package _02_ConditionalStatements.Book_3_2_SimpleConditionsExamProblems;

import java.util.Scanner;

public class B05_Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetHours = Integer.parseInt(scanner.nextLine());
        int allDays = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double availableDays = allDays * 0.9;
        double overtimeHours = availableDays * 2 * workers;
        double workHours = availableDays * 8 * workers;
        double availableHours = Math.floor(overtimeHours + workHours);

        double diff = Math.abs(availableHours - targetHours);
        if (availableHours >= targetHours) {
            System.out.printf("Yes!%.0f hours left.", diff);
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", diff);
        }


    }
}
