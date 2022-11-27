package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E07_SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	На първия ред a – цяло число в интервала [1 … 1000]
        //•	На втория ред b – цяло число в интервала [1 … 1000]
        //•	На третия ред максимален брой генерирани пароли – цяло число в интервала [1 … 1000000]
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int passNum = Integer.parseInt(scanner.nextLine());
        //•	A е символ с ASCII стойност в диапазона [35… 55]
        //•	B е символ с ASCII стойност в диапазона [64 … 96]
        //•	x e цяло число в диапазона [1… a]
        //•	y e цяло число в диапазона [1… b]
        //ABxyBA
        int A = '#';
        int B = '@';
        int passNumCounter = 0;
        for (int x = 1; x <= a; x++) {
            for (int y = 1; y <= b; y++) {
                if (passNumCounter >= passNum) {
                    break;
                }
                if (A > '7') {
                    A = '#';
                }
                if (B > '`') {
                    B = '@';
                }
                passNumCounter++;
                System.out.printf("%c%c%d%d%c%c|", A, B, x, y, B, A);
                A++;
                B++;
            }
            if (passNumCounter >= passNum) {
                break;
            }
        }
    }
}