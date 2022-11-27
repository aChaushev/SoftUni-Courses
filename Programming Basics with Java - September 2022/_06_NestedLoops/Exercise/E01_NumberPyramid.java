package _06_NestedLoops.Exercise;

import java.util.Scanner;

public class E01_NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int current = 1;
        boolean isBigger = false;
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                if (current > n) {
                    isBigger = true;
                    break;
                }
                System.out.printf("%d ", current);
                current++;
            }
            if (isBigger) {
                break;
            }
            System.out.println();
        }
    }
}
