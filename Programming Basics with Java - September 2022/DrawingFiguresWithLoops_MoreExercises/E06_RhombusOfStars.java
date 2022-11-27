package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E06_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int col = 1; col < row; col++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for (int row = n - 1; row >= 1; row--) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int col = 1; col < row; col++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
