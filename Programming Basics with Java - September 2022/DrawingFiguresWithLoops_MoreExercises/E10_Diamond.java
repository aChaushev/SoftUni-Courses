package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E10_Diamond {
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
                    System.out.print("-");

                }
                for (int col = 1; col < row; col++) {
                    System.out.print("-");
                }
                System.out.print("*");
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            for (int row = (n + 1) / 2 - 1; row >= 1; row--) {
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.print("*");
                for (int col = 1; col < row; col++) {
                    System.out.print("-");

                }
                for (int col = 1; col < row; col++) {
                    System.out.print("-");
                }
                System.out.print("*");
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
                    System.out.print("-");

                }
                for (int col = 1; col < row - 1; col++) {
                    System.out.print("-");
                }
                if (row != 1) {
                    System.out.print("*");
                }
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }

                System.out.println();
            }
            for (int row = (n + 1) / 2 - 1; row >= 1; row--) {
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.print("*");
                for (int col = 1; col < row; col++) {
                    System.out.print("-");

                }
                for (int col = 1; col < row - 1; col++) {
                    System.out.print("-");
                }
                if (row != 1) {
                    System.out.print("*");
                }
                for (int col = 1; col <= (n + 1) / 2 - row; col++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}
