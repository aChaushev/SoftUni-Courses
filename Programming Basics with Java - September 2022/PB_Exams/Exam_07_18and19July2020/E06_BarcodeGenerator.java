package PB_Exams.Exam_07_18and19July2020;

import java.util.Scanner;

public class E06_BarcodeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Num1 = scanner.nextLine();
        String Num2 = scanner.nextLine();

        for (int d1 = Num1.charAt(0); d1 <= Num2.charAt(0); d1++) {
            for (int d2 = Num1.charAt(1); d2 <= Num2.charAt(1); d2++) {
                for (int d3 = Num1.charAt(2); d3 <= Num2.charAt(2); d3++) {
                    for (int d4 = Num1.charAt(3); d4 <= Num2.charAt(3); d4++) {
                        if (d1 % 2 != 0 && d2 % 2 != 0 && d3 % 2 != 0 && d4 % 2 != 0) {
                            System.out.printf("%c%c%c%c ", d1, d2, d3, d4);
                        }
                    }
                }
            }
        }
    }
}
