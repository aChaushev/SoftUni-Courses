package _11_Arrays;

import java.util.Scanner;

public class P02_PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            numArr[i] = currentNum;
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.printf("%d ", numArr[i]);
        }
    }
}
