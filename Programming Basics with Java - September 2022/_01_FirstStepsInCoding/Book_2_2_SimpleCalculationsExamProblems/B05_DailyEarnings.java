package _01_FirstStepsInCoding.Book_2_2_SimpleCalculationsExamProblems;

import java.util.Scanner;

public class B05_DailyEarnings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int workDaysMonth = Integer.parseInt(scanner.nextLine());
        double moneyDay = Double.parseDouble(scanner.nextLine());
        double BGN = Double.parseDouble(scanner.nextLine());

        double monthlySalary = workDaysMonth * moneyDay;
        double yearSalary = 12 * monthlySalary + 2.5 * monthlySalary;
        yearSalary -= yearSalary * 0.25;
        double dalyEarningsInBGN = (yearSalary / 365) * BGN;
        System.out.printf("%.2f", dalyEarningsInBGN);
    }
}
