package _05_WhileLoop.Exercise;

import java.util.Scanner;

public class E02_ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxPoorGrades = Integer.parseInt(scanner.nextLine());
        int gradesSum = 0;
        int countAllTasks = 0;
        int countPoorGrades = 0;
        boolean breakTime = false;
        String lastTask = "";

        String input = scanner.nextLine();
        while (!input.equals("Enough")) {
            String currentTask = input;
            int currentGrade = Integer.parseInt(scanner.nextLine());
            lastTask = currentTask;
            countAllTasks++;
            gradesSum += currentGrade;

            if (currentGrade <= 4) {
                countPoorGrades++;
            }
            if (countPoorGrades >= maxPoorGrades) {
                breakTime = true;
                break;
            }

            input = scanner.nextLine();
        }
        if (breakTime) {
            System.out.printf("You need a break, %d poor grades.", countPoorGrades);
        } else {
            System.out.printf("Average score: %.2f%n", gradesSum * 1.0 / countAllTasks);
            System.out.printf("Number of problems: %d%n", countAllTasks);
            System.out.printf("Last problem: %s%n", lastTask);
        }
    }
}

