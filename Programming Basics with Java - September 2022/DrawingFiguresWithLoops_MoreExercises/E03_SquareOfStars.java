package DrawingFiguresWithLoops_MoreExercises;

import java.util.Scanner;

public class E03_SquareOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char star = '*';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(star + " ");
            }
            System.out.println();
        }
    }
}
