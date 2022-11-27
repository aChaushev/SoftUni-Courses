package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E01_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int row = Integer.parseInt(scanner.nextLine());
        int column = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0;
//        if (projection.equals("Premiere")) {
//            ticketPrice = 12.00;
//        } else if (projection.equals("Normal")) {
//            ticketPrice = 7.50;
//        } else if (projection.equals("Discount")) {
//            ticketPrice = 5.00;
//        }

        switch (projection) {
            case "Premiere":
                ticketPrice = 12.00;
                break;
            case "Normal":
                ticketPrice = 7.50;
                break;
            case "Discount":
                ticketPrice = 5.00;
                break;
            }

        double result = ticketPrice * row * column;
        System.out.printf("%.2f leva", result);
    }
}
