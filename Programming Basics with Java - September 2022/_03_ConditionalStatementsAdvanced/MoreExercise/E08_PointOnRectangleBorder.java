package _03_ConditionalStatementsAdvanced.MoreExercise;

import java.util.Scanner;

public class E08_PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //x1, y1, x2, y2, x и y
        //x1 < x2 и y1 < y2
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());

        if (((x == x1 || x == x2) && (y1 <= y && y <= y2)) || ((y == y1 || y == y2) && (x1 <= x && x <= x2))) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }
    }
}
