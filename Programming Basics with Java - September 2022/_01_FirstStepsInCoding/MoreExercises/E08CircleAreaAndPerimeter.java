package _01_FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class E08CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double area = Math.PI * r * r;
        double parameter = 2 * Math.PI * r;
        System.out.printf("%.2f %n", area);
        System.out.printf("%.2f", parameter);
    }
}
