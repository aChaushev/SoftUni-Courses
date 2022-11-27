package _06_NestedLoops.Exercise;

import java.util.Scanner;

public class E04_TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();


        int averageCounter = 0;
        double totalGradeCounter = 0;
        while (!command.equals("Finish")) {
            String name = command;
            double gradeCounter = 0;
            for (int i = 1; i <= n; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                averageCounter++;
                gradeCounter += grade;
                totalGradeCounter += grade;
            }
            System.out.printf("%s - %.2f.%n", name, gradeCounter / n);
            command = scanner.nextLine();
        }

        System.out.printf("Student's final assessment is %.2f.", totalGradeCounter / averageCounter);
    }
}
