package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E08LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seriesTitle = scanner.nextLine();
        int epTime = Integer.parseInt(scanner.nextLine());
        int breakTime = Integer.parseInt(scanner.nextLine());

        double lunchTime = breakTime / 8.0;
        double restTime = breakTime / 4.0;
        double timeLeft = breakTime - (lunchTime + restTime);

        double diff = Math.ceil(Math.abs(timeLeft - epTime));
        if (timeLeft >= epTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.",
                    seriesTitle, diff);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.",
                    seriesTitle, diff);
        }
    }
}
