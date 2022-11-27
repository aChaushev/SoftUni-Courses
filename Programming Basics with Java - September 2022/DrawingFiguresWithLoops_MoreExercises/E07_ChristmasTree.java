package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E07_ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            System.out.print(" ");
            System.out.print("|");
            System.out.print(" ");
            for (int col = 0; col < row; col++) {
                System.out.print("*");
            }
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
