package PB_Exams.Exam_02_6and7April2019;

import java.util.Scanner;

public class E01_OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hallRent = Double.parseDouble(scanner.nextLine());

        double statuettes = hallRent * 0.7;
        double kettering = statuettes * 0.85;
        double voiceOver = kettering * 0.5;

        double allExpenses = hallRent + statuettes + kettering + voiceOver;
        System.out.printf("%.2f", allExpenses);
    }
}
