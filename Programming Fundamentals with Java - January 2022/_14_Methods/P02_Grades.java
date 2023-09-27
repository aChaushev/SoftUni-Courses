package _14_Methods;

import java.util.Scanner;

public class P02_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double gradeInput = Double.parseDouble(scanner.nextLine());
        printGrade(gradeInput);

    }
    public static void printGrade(double grade) {
        if (2.00 <= grade && grade <= 2.99) {
            System.out.println("Fail");
        } else if (3.00 <= grade && grade <= 3.49) {
            System.out.println("Poor");
        } else if (grade <= 4.49) {
            System.out.println("Good");
        } else if (grade <= 5.49) {
            System.out.println("Very good");
        } else if (grade <= 6.00) {
            System.out.println("Excellent");
        }
    }
}
