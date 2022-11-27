package PreliminaryExam_21_22Oct;

import java.util.Scanner;

public class E01_Excursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleInGroup = Integer.parseInt(scanner.nextLine());
        int overnightStays = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int museumTickets = Integer.parseInt(scanner.nextLine());

        double totalSum = peopleInGroup * (overnightStays * 20 + transportCards * 1.6 + museumTickets * 6);
        totalSum *= 1.25;
        System.out.printf("%.2f", totalSum);
    }
}
