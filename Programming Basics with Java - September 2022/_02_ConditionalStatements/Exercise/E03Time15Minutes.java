package _02_ConditionalStatements.Exercise;

import java.util.Scanner;

public class E03Time15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

//        if (minutes < 45) {
//            minutes = minutes +15;
//        } else if (minutes >= 45) {
//            hours = hours + 1;
//            minutes = minutes - 60 + 15;
//        }
//        if (hours >= 24) {
//            hours = hours - 24;
//        }
//        if (minutes < 10) {
//            System.out.printf("%d:0%d", hours, minutes);
//        } else {
//            System.out.printf("%d:%d", hours, minutes);
//        }

        int totalMinutes = hours * 60 + minutes + 15;

        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;

        if (hours > 23) {
            hours = hours - 24;
        }
        if (minutes < 10) {
            System.out.printf("%d:0%d", hours, minutes);
        } else {
            System.out.printf("%d:%d", hours, minutes);
        }
    }
}
