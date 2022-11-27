package PB_Exams.Exam_05_9and10March2019;

import java.util.Scanner;

public class E03_WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stage = scanner.nextLine();
        String ticketType = scanner.nextLine();
        int ticketCnt = Integer.parseInt(scanner.nextLine());
        boolean trophyPic = scanner.nextLine().equals("Y");

        double ticketPrice = 0;
        if (stage.equals("Quarter final")) {
            if (ticketType.equals("Standard")) {
                ticketPrice = 55.50;
            } else if (ticketType.equals("Premium")) {
                ticketPrice = 105.20;
            } else if (ticketType.equals("VIP")) {
                ticketPrice = 118.90;
            }
        } else if (stage.equals("Semi final")) {
            if (ticketType.equals("Standard")) {
                ticketPrice = 75.88;
            } else if (ticketType.equals("Premium")) {
                ticketPrice = 125.22;
            } else if (ticketType.equals("VIP")) {
                ticketPrice = 300.40;
            }
        } else if (stage.equals("Final")) {
            if (ticketType.equals("Standard")) {
                ticketPrice = 110.10;
            } else if (ticketType.equals("Premium")) {
                ticketPrice = 160.66;
            } else if (ticketType.equals("VIP")) {
                ticketPrice = 400;
            }
        }

        double totalTicketsPrice = ticketPrice * ticketCnt;
        if (totalTicketsPrice > 4000) {
            totalTicketsPrice *= 0.75;
            trophyPic = false;
        } else if (totalTicketsPrice > 2500) {
            totalTicketsPrice *= 0.9;
        }
        if (trophyPic) {
            totalTicketsPrice += ticketCnt * 40;
        }
        System.out.printf("%.2f", totalTicketsPrice);
    }
}
