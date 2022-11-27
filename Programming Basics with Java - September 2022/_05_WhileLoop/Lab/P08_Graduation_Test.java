package _05_WhileLoop.Lab;

import java.util.Scanner;

public class P08_Graduation_Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String student = scanner.nextLine();

        int excludedCounter = 0;
        int classCounter = 1;
        double gradeSum = 0;
        boolean isExcluded = false;
        while (classCounter <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            if (grade < 4.00) {
                excludedCounter++;
                if (excludedCounter > 1) {
                    isExcluded = true;
                    break;
                }
                continue;
            }
            classCounter++;
            gradeSum += grade;
        }
        if (isExcluded) {
            System.out.printf("%s has been excluded at %d grade", student, classCounter);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", student, gradeSum / 12);
        }
    }
}
