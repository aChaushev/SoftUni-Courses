package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E11_HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Брой дни – цяло число в интервала [1 … 5]
        //•	Брой часове за всеки един от дните - цяло число в интервала [1 … 24]

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;
        double daySum = 0;
        for (int d = 1; d <= days; d++) {
            for (int h = 1; h <= hours; h++) {
                if (d % 2 == 0 && h % 2 != 0) {
                    daySum += 2.5;
                } else if (d % 2 != 0 && h % 2 == 0) {
                    daySum += 1.25;
                } else {
                    daySum += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n", d, daySum);
            totalSum += daySum;
            daySum = 0;
        }
        System.out.printf("Total: %.2f leva", totalSum);
    }
}
