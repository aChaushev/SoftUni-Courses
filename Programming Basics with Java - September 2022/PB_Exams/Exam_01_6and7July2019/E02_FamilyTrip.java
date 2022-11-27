package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E02_FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Бюджетът, с който разполагат – реално число в интервала [1.00 … 10000.00]
        //•	Брой нощувки – цяло число в интервала [0 … 1000]
        //•	Цена за нощувка – реално число в интервала [1.00 … 500.00]
        //•	Процент за допълнителни разходи – цяло число в интервала [0 … 100]
        double budget = Double.parseDouble(scanner.nextLine());
        int overnightStay = Integer.parseInt(scanner.nextLine());
        double overnightStayPrice = Double.parseDouble(scanner.nextLine());
        int percentOtherExpenses = Integer.parseInt(scanner.nextLine());

        if (overnightStay > 7) {
            overnightStayPrice -= overnightStayPrice * 0.05;
        }
        double totalOvernightStay = overnightStay * overnightStayPrice;
        double otherExpenses = budget * percentOtherExpenses / 100.0;
        double totalExpenses = totalOvernightStay + otherExpenses;

        double diff = Math.abs(budget - totalExpenses);
        if (budget >= totalExpenses) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", diff);
        } else {
            System.out.printf("%.2f leva needed.", diff);
        }
    }
}
