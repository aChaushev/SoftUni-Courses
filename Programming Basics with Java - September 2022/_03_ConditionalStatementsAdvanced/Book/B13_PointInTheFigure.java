package _03_ConditionalStatementsAdvanced.Book;

import java.util.Scanner;

public class B13_PointInTheFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        boolean outRec1 = x < 0 || x > 3 * h || y < 0 || y > h;
        boolean outRec2 = x < h || x > 2 * h || y < h || y > 4 * h;

        boolean inRec1 = (0 < x && x < 3 * h) && (0 < y && y < h);
        boolean inRec2 = (h < x && x < 2 * h) && (h < y && y < 4 * h);
        boolean commonBorder = h < x && x < 2 * h && y == h;

        if (outRec1 && outRec2) {
            System.out.println("outside");
        } else if (inRec1 || inRec2 || commonBorder) {
            System.out.println("inside");
        } else {
            System.out.println("border");
        }
    }
}
