package _03_ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P07_WorkingHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        String dayOfWeek = scanner.nextLine();

        boolean workDay = dayOfWeek.equals("Monday") ||
                dayOfWeek.equals("Tuesday") ||
                dayOfWeek.equals("Wednesday") ||
                dayOfWeek.equals("Thursday") ||
                dayOfWeek.equals("Friday") ||
                dayOfWeek.equals("Saturday");
        boolean workHours = 10 <= hour && hour <= 18;

        if (workHours && workDay) {
            System.out.println("open");
        } else {
            System.out.println("closed");
        }
    }
}
