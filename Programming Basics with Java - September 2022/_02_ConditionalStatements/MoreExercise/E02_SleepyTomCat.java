package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E02_SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());

        int realPlayTime = (365 - holidays) * 63 + holidays * 127;

        int normDiff = Math.abs(realPlayTime - 30000);
        int hours = normDiff / 60;
        int minutes = normDiff % 60;
        if (realPlayTime > 30000) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);
        }
    }
}
