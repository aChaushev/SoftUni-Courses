package _07_ExamPreparation.July;

import java.util.Scanner;

public class P06_BarcodeGenerator_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        int startUnits = firstNum % 10;
        int startTens = firstNum / 10 % 10;
        int startHundreds = firstNum / 100 % 10;
        int startThousands = firstNum / 1000 % 10;

        int endUnits = secondNum % 10;
        int endTens = secondNum / 10 % 10;
        int endHundreds = secondNum / 100 % 10;
        int endThousands = secondNum / 1000 % 10;

        for (int i = startThousands; i <= endThousands; i++) {
            for (int j = startHundreds; j <= endHundreds; j++) {
                for (int k = startTens; k <= endTens; k++) {
                    for (int l = startUnits; l <= endUnits; l++) {
                        if (i % 2 != 0 && j % 2 != 0 && k % 2 != 0 && l % 2 != 0) {
                            System.out.printf("%d%d%d%d ", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
