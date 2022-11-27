package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E08_Sunglasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= 2 * n; col++) {
                if (row == 1 || row == n) {
                    System.out.print("*");
                } else {
                    if (col == 1 || col == 2 * n) {
                        System.out.print("*");
                    } else if (col > 1 && col < 2 * n) {
                        System.out.print("/");
                    }
                }
            }
            if (n % 2 !=0){
                if (row == (n / 2) + 1) {
                    for (int col = 2 * n + 1; col <= 2 * n + n; col++) {
                        System.out.print("|");
                    }
                } else {
                    for (int col = 2 * n + 1; col <= 2 * n + n; col++) {
                        System.out.print(" ");
                    }
                }
            } else {
                if (row == (n / 2)) {
                    for (int col = 2 * n + 1; col <= 2 * n + n; col++) {
                        System.out.print("|");
                    }
                } else {
                    for (int col = 2 * n + 1; col <= 2 * n + n; col++) {
                        System.out.print(" ");
                    }
                }
            }

            for (int col = 1; col <= 2 * n; col++) {
                if (row == 1 || row == n) {
                    System.out.print("*");
                } else {
                    if (col == 1 || col == 2 * n) {
                        System.out.print("*");
                    } else if (col > 1 && col < 2 * n) {
                        System.out.print("/");
                    }
                }
            }
            System.out.println();
        }
    }
}

