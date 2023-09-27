package _03_WorkingWith_Abstraction_Lab;

import java.util.Scanner;

public class _01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //горна част
        //бр. редове == n
        printTopPart(n);

        //средна част -> 1 ред -> n = бр. на звездите
        printMiddlePart(n);

        //долна част
        printBottomPart(n);

    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddlePart(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row <= n - 1; row++) {
            //принтирам ред
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        // всеки ред -> {брой интервали = n - row}{брой звезди = row}
        //n = 3
        //1 ред -> 2инт + 1зв
        //2 ред -> 1 инт + 2зв
        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }
        printMiddlePart(row);


    }
}
