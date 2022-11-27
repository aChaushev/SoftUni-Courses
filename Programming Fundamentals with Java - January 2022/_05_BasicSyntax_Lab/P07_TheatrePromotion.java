package _05_BasicSyntax_Lab;

import java.util.Scanner;

public class P07_TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int ticketPrice = 0;
        boolean isValid = true;
        if (0 <= age && age <= 18) {
            if (dayType.equals("Weekday")) {
                ticketPrice = 12;
            } else if (dayType.equals("Weekend")) {
                ticketPrice = 15;
            } else if (dayType.equals("Holiday")) {
                ticketPrice = 5;
            }
        } else if (18 < age && age <= 64) {
            if (dayType.equals("Weekday")) {
                ticketPrice = 18;
            } else if (dayType.equals("Weekend")) {
                ticketPrice = 20;
            } else if (dayType.equals("Holiday")) {
                ticketPrice = 12;
            }
        } else if (64 < age && age <= 122) {
            if (dayType.equals("Weekday")) {
                ticketPrice = 12;
            } else if (dayType.equals("Weekend")) {
                ticketPrice = 15;
            } else if (dayType.equals("Holiday")) {
                ticketPrice = 10;
            }
        } else {
            isValid = false;
            System.out.println("Error!");
        }

        if (isValid) {
            System.out.printf("%d$", ticketPrice);
        }
    }
}
