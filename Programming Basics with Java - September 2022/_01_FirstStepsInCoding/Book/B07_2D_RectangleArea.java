package _01_FirstStepsInCoding.Book;

import java.util.Scanner;

public class B07_2D_RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double a = Math.abs(x1 - x2);
        double b = Math.abs(y2 - y1);
        double area = a * b;
        double parameter = 2 * a + 2 * b;
        if (area % 1 > 0) {
            System.out.println(area);
        } else {
            System.out.printf("%.0f%n", area);
        }
        if (parameter % 1 > 0) {
            System.out.println(parameter);
        } else {
            System.out.printf("%.0f%n", parameter);
        }
    }
}
