package PB_Exams.Exam_02_6and7April2019;

import java.util.Scanner;

public class E06_CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieTitle = scanner.nextLine();

        int studentTicketCnt = 0;
        int standardTicketCnt = 0;
        int kidTicketCnt = 0;

        while (!movieTitle.equals("Finish")) {
            int freeSeating = Integer.parseInt(scanner.nextLine());
            String ticketType = scanner.nextLine();
            int currentMovieSeating = 0;
            while (!ticketType.equals("End")) {
                if (ticketType.equals("student")) {
                    studentTicketCnt++;
                    currentMovieSeating++;
                } else if (ticketType.equals("standard")) {
                    standardTicketCnt++;
                    currentMovieSeating++;
                } else if (ticketType.equals("kid")) {
                    kidTicketCnt++;
                    currentMovieSeating++;
                }
                if (currentMovieSeating >= freeSeating) {
                    break;
                }
                ticketType = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", movieTitle, currentMovieSeating * 1.0 / freeSeating * 100);
            movieTitle = scanner.nextLine();
        }
        int totalTickets = studentTicketCnt + standardTicketCnt + kidTicketCnt;
        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", studentTicketCnt * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardTicketCnt * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidTicketCnt * 1.0 / totalTickets * 100);
    }
}
