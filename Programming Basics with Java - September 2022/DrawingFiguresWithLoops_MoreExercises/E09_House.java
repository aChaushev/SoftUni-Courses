package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E09_House {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        if (n % 2 == 0) {
            for (int row = 1; row <= (n + 1) / 2; row++) {
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.print("*");
                for (int col = 1; col < row; col++) {
                    System.out.print("*");
                }
                for (int col = 0; col < row; col++) {
                    System.out.print("*");
                }
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.println();
            }

        } else {
            for (int row = 1; row <= (n + 1) / 2; row++) {
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.print("*");
                for (int col = 1; col < row; col++) {
                    System.out.print("*");
                }
                for (int col = 1; col < row; col++) {
                    System.out.print("*");
                }
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }

        for (int row = 1; row <= n / 2; row++) {
            for (int col = 1; col <= n; col++) {
                if (col == 1 || col == n) {
                    System.out.print("|");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
