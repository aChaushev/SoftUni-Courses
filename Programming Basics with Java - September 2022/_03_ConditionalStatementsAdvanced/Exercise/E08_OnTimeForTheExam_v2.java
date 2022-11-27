package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E08_OnTimeForTheExam_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Първият ред съдържа час на изпита – цяло число от 0 до 23.
        //•	Вторият ред съдържа минута на изпита – цяло число от 0 до 59.
        //•	Третият ред съдържа час на пристигане – цяло число от 0 до 23.
        //•	Четвъртият ред съдържа минута на пристигане – цяло число от 0 до 59.
        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examInMinute = examHour * 60 + examMinute;
        int arrivalInMinute = arrivalHour * 60 + arrivalMinute;

        int diff = Math.abs(examInMinute - arrivalInMinute);
        int diffHours = diff / 60;
        int diffMinutes = diff % 60;
        if (arrivalInMinute > examInMinute) {
            System.out.println("Late");
        } else if (arrivalInMinute <= examInMinute && diff <= 30) {
            System.out.println("On time");
        } else if (arrivalInMinute < examInMinute && diff > 30) {
            System.out.println("Early");
        }

        if (arrivalInMinute < examInMinute && diff < 60) {
            System.out.printf("%d minutes before the start", diff);
        } else if (arrivalInMinute < examInMinute && diff >= 60) {
                System.out.printf("%d:%02d hours before the start", diffHours, diffMinutes);
        } else if (arrivalInMinute > examInMinute && diff < 60) {
            System.out.printf("%d minutes after the start", diff);
        } else if (arrivalInMinute > examInMinute && diff >= 60) {
                System.out.printf("%d:%02d hours after the start", diffHours, diffMinutes);

        }
    }
}
