package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E08_OnTimeForTheExam_Book {
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

        int diff = arrivalInMinute - examInMinute;
        int diffHours = Math.abs(diff / 60);
        int diffMinutes = Math.abs(diff % 60);

        String late = "Late";
        String onTime = "On time";
        String early = "Early";
        String studentArrival = late;
        if (diff < -30) {
            studentArrival = early;
        } else if (diff <= 0) {
            studentArrival = onTime;
        }

        String result = "";
        if (diff != 0) {
            if (diffHours > 0) {
                result = String.format("%d:%02d hours", diffHours, diffMinutes);
            } else {
                result = diffMinutes + " minutes";
            }
            if (diff < 0) {
                result += " before the start";
            } else {
                result += " after the start";
            }
        }
        System.out.println(studentArrival);
        if (!result.isEmpty()) {
            System.out.println(result);
        }
    }
}
