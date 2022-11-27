package _01_FirstStepsInCoding.Book_2_2_SimpleCalculationsExamProblems;

import java.util.Scanner;

public class B04_Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoin = Integer.parseInt(scanner.nextLine());
        double CNY = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double EUR = (bitcoin * 1168) / 1.95 + ((CNY * 0.15) * 1.76) / 1.95;
        EUR -= EUR * (commission / 100);
        System.out.println(EUR);
    }
}
