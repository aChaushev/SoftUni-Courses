package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E01_MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieTitle = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int ticketsPerDay = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        int cinemaProfitPercent = Integer.parseInt(scanner.nextLine());

        double profit = days * ticketsPerDay * ticketPrice;
        profit -= profit * cinemaProfitPercent / 100;

        System.out.printf("The profit from the movie %s is %.2f lv.", movieTitle, profit);
    }
}
