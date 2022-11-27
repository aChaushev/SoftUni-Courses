package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E01_Lunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreadsCnt = Integer.parseInt(scanner.nextLine());
        int eggCrustCnt = Integer.parseInt(scanner.nextLine());
        int cookiesCnt = Integer.parseInt(scanner.nextLine());

        double totalExpense = easterBreadsCnt * 3.2 + cookiesCnt * 5.4 + eggCrustCnt * 4.35 + (eggCrustCnt * 12.0 * 0.15);
        System.out.printf("%.2f", totalExpense);
    }
}
