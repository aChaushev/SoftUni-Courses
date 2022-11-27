package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E04_CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        for (int i = n1; i <= n2; i++) {
            for (int j = n1; j <= n2; j++) {
                for (int k = n1; k <= n2; k++) {
                    for (int l = n1; l <= n2; l++) {
                        if ((i % 2 == 0) && (l % 2 != 0) && (i > l) && ((j + k) % 2 == 0)) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                        if ((i % 2 != 0) && (l % 2 == 0) && (i > l) && ((j + k) % 2 == 0)) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}