package _05_WhileLoop.Lab;

import java.util.Scanner;

public class P08_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        boolean isExcluded = false;
        double gradeSum = 0;
        int poorGardeCounter = 0;
        int year = 1;

        while (year <= 12) {

            if (poorGardeCounter > 1) {
                isExcluded = true;
                break;
            }
            double currentGrade = Double.parseDouble(scanner.nextLine());

            if (currentGrade < 4.00) {
                poorGardeCounter++;
                continue;
            }
            gradeSum += currentGrade;
            year++;
        }

        if (isExcluded) {
            System.out.printf("%s has been excluded at %d grade", name, year);
        } else {
            System.out.printf("%s graduated. Average grade: %.2f", name, gradeSum / 12);
        }
    }
}
