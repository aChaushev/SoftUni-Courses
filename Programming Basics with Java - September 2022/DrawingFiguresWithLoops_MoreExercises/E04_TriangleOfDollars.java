package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E04_TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char dollar = '$';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(dollar + " ");
            }
            System.out.println();
        }
    }
}
