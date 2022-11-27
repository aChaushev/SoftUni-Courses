package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E02_ExamPreparation_my {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxPoorGrade = Integer.parseInt(scanner.nextLine());
        String currentTask = scanner.nextLine();
        String outputTask = "";
        int problemsNum = 0;
        int poorGradeNum = 0;
        int gradeSum = 0;
        boolean breakTime = false;

        while (!currentTask.equals("Enough")) {
            int currentGrade = Integer.parseInt(scanner.nextLine());
            if (currentGrade <= 4) {
                poorGradeNum++;
            }
            if (poorGradeNum == maxPoorGrade) {
                breakTime = true;
                break;
            }

            gradeSum += currentGrade;
            problemsNum++;
            outputTask = currentTask;
            currentTask = scanner.nextLine();

        }
        if (breakTime) {
            System.out.printf("You need a break, %d poor grades.", problemsNum);
        } else {
            System.out.printf("Average score: %.2f%n", gradeSum * 1.0 / problemsNum);
            System.out.printf("Number of problems: %d%n", problemsNum);
            System.out.printf("Last problem: %s%n", outputTask);
        }
    }
}
