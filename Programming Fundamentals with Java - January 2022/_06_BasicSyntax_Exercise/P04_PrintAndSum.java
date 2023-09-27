package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P04_PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = firstNum; i <= lastNum; i++) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.printf("%nSum: %d", sum);
    }
}
