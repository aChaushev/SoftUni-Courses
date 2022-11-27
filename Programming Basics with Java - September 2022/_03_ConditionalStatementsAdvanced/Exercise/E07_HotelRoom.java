package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E07_HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	На първия ред е месецът – May, June, July, August, September или October
        //•	На втория ред е броят на нощувките – цяло число в интервала [0 ... 200]
        String month = scanner.nextLine();
        int overnightStay = Integer.parseInt(scanner.nextLine());

        double studioPrice = 0;
        double apartmentPrice = 0;
        switch (month) {
            case "May":
            case "October":
                studioPrice = 50;
                apartmentPrice = 65;
                break;
            case "June":
            case "September":
                studioPrice = 75.20;
                apartmentPrice = 68.70;
                break;
            case "July":
            case "August":
                studioPrice = 76;
                apartmentPrice = 77;
                break;
        }
        double totalStudioPrice = studioPrice * overnightStay;
        double totalApartPrice = apartmentPrice * overnightStay;
        if (overnightStay > 7 && overnightStay <=14 && (month.equals("May") || month.equals("October"))) {
            totalStudioPrice = totalStudioPrice - totalStudioPrice * 0.05;
        } else if (overnightStay > 14 && (month.equals("May") || month.equals("October"))) {
            totalStudioPrice = totalStudioPrice - totalStudioPrice * 0.30;
        } else if (overnightStay > 14 && (month.equals("June") || month.equals("September"))) {
            totalStudioPrice = totalStudioPrice - totalStudioPrice * 0.20;
        }
        if (overnightStay > 14) {
            totalApartPrice = totalApartPrice - totalApartPrice * 0.10;
        }
        //•	На първия ред: "Apartment: {цена за целият престой} lv."
        //•	На втория ред: "Studio: {цена за целият престой} lv."

        System.out.printf("Apartment: %.2f lv. %n", totalApartPrice);
        System.out.printf("Studio: %.2f lv.", totalStudioPrice);

    }
}
