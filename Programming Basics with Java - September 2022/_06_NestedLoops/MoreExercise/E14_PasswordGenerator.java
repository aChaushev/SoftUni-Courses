package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E14_PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Входът се чете от конзолата и се състои от две цели числа n и l в интервала [1…9], по едно на ред.
        int n = Integer.parseInt(scanner.nextLine());
        int l = Integer.parseInt(scanner.nextLine());
        //•	Символ 1: цифра от 1 до n.
        //•	Символ 2: цифра от 1 до n.
        //•	Символ 3: малка буква измежду първите l букви на латинската азбука.
        //•	Символ 4: малка буква измежду първите l букви на латинската азбука.
        //•	Символ 5: цифра от 1 до n, по-голяма от първите 2 цифри.

        for (int c1 = 1; c1 <= n; c1++) {
            for (int c2 = 1; c2 <= n; c2++) {
                for (int c3 = 'a'; c3 < 'a' + l; c3++) {
                    for (int c4 = 'a'; c4 < 'a' + l; c4++) {
                        for (int c5 = Math.max(c1, c2) + 1; c5 <= n; c5++) {        //  for (int c5 = 1; c5 <= n; c5++) {
                            System.out.printf("%d%d%c%c%d ", c1, c2, c3, c4, c5);   //      if (c5 > c1 && c5 > c2) {
                        }                                                           //          System.out.pr...
                    }
                }
            }
        }
    }
}

