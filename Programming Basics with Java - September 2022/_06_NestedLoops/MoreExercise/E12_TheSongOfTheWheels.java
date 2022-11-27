package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E12_TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //От конзолата се чете едно цяло число (контролната стойност): M – цяло число в интервала [4 … 144];
        int controlValue = Integer.parseInt(scanner.nextLine());

        String password = "";
        int valueCounter = 0;
        boolean thereIsPass = false;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        if (a < b && c > d && a * b + c * d == controlValue) {
                            valueCounter++;
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                            if (valueCounter == 4) {
                                password = "" + a + b + c + d;
                                thereIsPass = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        if (thereIsPass) {
            System.out.printf("Password: %s", password);
        } else {
            System.out.println("No!");
        }
    }
}
