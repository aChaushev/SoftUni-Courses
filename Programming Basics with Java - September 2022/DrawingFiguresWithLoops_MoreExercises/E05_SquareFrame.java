package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E05_SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char plus = '+';
        char minus = '-';
        char vertLine = '|';
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                for (int j = 1; j <= n; j++) {
                    if (j == 1 || j == n) {
                        System.out.print(plus + " ");
                    } else if (j > 1 && j < n){
                        System.out.print(minus + " ");
                    }
                }
            } else if (i > 1 && i < n) {
                for (int j = 1; j <= n; j++) {
                    if (j == 1 || j == n) {
                        System.out.print(vertLine + " ");
                    } else if (j > 1 && j < n){
                        System.out.print(minus + " ");
                    }
                }
            }
            System.out.println();
        }
    }
}
