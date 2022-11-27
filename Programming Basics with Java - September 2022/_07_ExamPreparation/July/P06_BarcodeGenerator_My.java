package _07_ExamPreparation.July;

import java.util.Scanner;

public class P06_BarcodeGenerator_My {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        int digit11 = firstNum % 10;
        int digit21 = secondNum % 10;

        firstNum = firstNum / 10;
        secondNum = secondNum / 10;
        int digit12 = firstNum % 10;
        int digit22 = secondNum % 10;

        firstNum = firstNum / 10;
        secondNum = secondNum / 10;
        int digit13 = firstNum % 10;
        int digit23 = secondNum % 10;

        firstNum = firstNum / 10;
        secondNum = secondNum / 10;
        int digit14 = firstNum % 10;
        int digit24 = secondNum % 10;

        for (int i = digit14; i <= digit24; i++) {
            for (int j = digit13; j <= digit23; j++) {
                for (int k = digit12; k <= digit22; k++) {
                    for (int l = digit11; l <= digit21; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}

