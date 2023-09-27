package _15_Methods_Exercise;

import java.util.Scanner;

public class E03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        printSymbolsInRange(symbol1, symbol2);
    }

    public static void printSymbolsInRange(char symbol1, char symbol2) {
//        for (char symbol = (char) (symbol1 + 1); symbol < symbol2; symbol++) {
//            System.out.println(symbol + " ");
//        }
        for (int i = Math.min(symbol1, symbol2) + 1; i < Math.max(symbol1, symbol2); i++) {
            System.out.printf("%c ", i);
        }
    }
}
