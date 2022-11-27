package PB_Exams.Exam_03_15and16June2019;

import java.util.Scanner;

public class E03_FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String film = scanner.nextLine();
        String filmPackage = scanner.nextLine();
        int ticketsNum = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0;
        if (film.equals("John Wick")) {
            if (filmPackage.equals("Drink")) {
                ticketPrice = 12;
            } else if (filmPackage.equals("Popcorn")) {
                ticketPrice = 15;
            } else if (filmPackage.equals("Menu")) {
                ticketPrice = 19;
            }

        } else if (film.equals("Star Wars")) {
            if (filmPackage.equals("Drink")) {
                ticketPrice = 18;
            } else if (filmPackage.equals("Popcorn")) {
                ticketPrice = 25;
            } else if (filmPackage.equals("Menu")) {
                ticketPrice = 30;
            }
            if (ticketsNum >= 4) {
                ticketPrice = ticketPrice * 0.7;
            }

        } else if (film.equals("Jumanji")) {
            if (filmPackage.equals("Drink")) {
                ticketPrice = 9;
            } else if (filmPackage.equals("Popcorn")) {
                ticketPrice = 11;
            } else if (filmPackage.equals("Menu")) {
                ticketPrice = 14;
            }
            if (ticketsNum == 2) {
                ticketPrice = ticketPrice * 0.85;
            }
        }
        System.out.printf("Your bill is %.2f leva.", ticketPrice * ticketsNum);
    }
}
