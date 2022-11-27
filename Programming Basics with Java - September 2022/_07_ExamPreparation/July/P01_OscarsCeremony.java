package _07_ExamPreparation.July;

import java.util.Scanner;

public class P01_OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hallRent = Integer.parseInt(scanner.nextLine());

        //• Статуетки – цената им е 30% по-малка от наема на залата
        //• Кетъринг – цената му е 15% по-малка от тази на статуетките
        //• Озвучаване – цената му е 1 / 2 от цената за кетъринг

        double statues = hallRent - hallRent * 0.3;
        double catering = statues - statues * 0.15;
        double voiceover = catering / 2;

        double allExpenses = hallRent + statues + catering + voiceover;

        System.out.printf("%.2f", allExpenses);
    }
}
