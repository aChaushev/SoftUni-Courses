package _06_NestedLoops.MoreExercise;

import java.util.Scanner;

public class E13_PrimePairs__ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	На първия ред – началната стойност на първите първата двойка числа – цяло положително число в диапазона [10… 90]
        //•	На втория ред – началната стойност на втората двойка числа – цяло положително число в диапазона [10… 90]
        //•	На третия ред – разликата между началната и крайната стойност на  първата двойка числа – цяло положително число в диапазона [1… 9]
        //•	На четвъртия ред – разликата между началната и крайната стойност на  втората двойка числа – цяло положително число в диапазона [1… 9]
        int beginning12 = Integer.parseInt(scanner.nextLine());
        int beginning34 = Integer.parseInt(scanner.nextLine());
        int diff12 = Integer.parseInt(scanner.nextLine());
        int diff34 = Integer.parseInt(scanner.nextLine());

        int end12 = beginning12 + diff12;
        int end34 = beginning34 + diff34;
        int primeNumCountChecker12 = 0;
        int primeNumCountChecker34 = 0;
        for (int d12 = beginning12; d12 <= end12; d12++) {
            for (int d34 = beginning34; d34 <= end34; d34++) {
                for (int i12 = 2; i12 <= d12; i12++) { // d12 primeChecker
                    if (d12 % i12 == 0) {
                        primeNumCountChecker12++;
                    }
                }
                if (primeNumCountChecker12 == 1) {         // d12 primeChecker
                    for (int i34 = 2; i34 <= d34; i34++) { // d34 primeChecker
                        if (d34 % i34 == 0) {
                            primeNumCountChecker34++;
                        }
                    }
                    if (primeNumCountChecker34 == 1) {
                        System.out.printf("%d%d%n", d12, d34);
                    }                                     // d34 primeChecker
                }
                primeNumCountChecker12 = 0;
                primeNumCountChecker34 = 0;
            }
        }
    }
}
