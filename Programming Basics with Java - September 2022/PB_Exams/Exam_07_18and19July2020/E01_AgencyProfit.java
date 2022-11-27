package PB_Exams.Exam_07_18and19July2020;

import java.util.Scanner;

public class E01_AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String airlineName = scanner.nextLine();
        int adultsTicketCnt = Integer.parseInt(scanner.nextLine());
        int childrenTicketCnt = Integer.parseInt(scanner.nextLine());
        double netAdultsTicketPrice = Double.parseDouble(scanner.nextLine());
        double serviceChargeCost = Double.parseDouble(scanner.nextLine());

        double childrenTicketPrice = netAdultsTicketPrice * 0.3 + serviceChargeCost;
        double adultsTicketPrice = netAdultsTicketPrice + serviceChargeCost;
        double allTicketsCost = adultsTicketCnt * adultsTicketPrice + childrenTicketCnt * childrenTicketPrice;
        double agencyProfit = allTicketsCost * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", airlineName, agencyProfit);
    }
}
