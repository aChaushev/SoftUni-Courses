package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E04_Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsNum = Integer.parseInt(scanner.nextLine());

        double gradesSum = 0;
        int topGrades = 0;
        int goodGrades = 0;
        int averageGrades = 0;
        int weakGrades = 0;
        for (int i = 1; i <= studentsNum; i++) {
            double studentGrade = Double.parseDouble(scanner.nextLine());
            gradesSum += studentGrade;
            if (studentGrade < 3.00) {
                weakGrades++;
            } else if (studentGrade < 4.00) {
                averageGrades++;
            } else if (studentGrade < 5.00) {
                goodGrades++;
            } else {
                topGrades++;
            }
        }
        System.out.printf("Top students: %.2f%%%n", topGrades * 1.00 / studentsNum * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", goodGrades * 1.00 / studentsNum * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", averageGrades * 1.00 / studentsNum * 100);
        System.out.printf("Fail: %.2f%%%n", weakGrades * 1.00 / studentsNum * 100);
        System.out.printf("Average: %.2f", gradesSum / studentsNum);
    }
}
