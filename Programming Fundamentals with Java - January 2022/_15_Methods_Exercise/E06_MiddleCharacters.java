package _15_Methods_Exercise;

import java.util.Scanner;

public class E06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        printMiddleCharacter(input);

    }

    public static void printMiddleCharacter(String text) {

        if (text.length() % 2 != 0) {
            System.out.println(text.charAt(text.length() / 2));
        } else {
            System.out.println(text.charAt(text.length() / 2 - 1) + "" + text.charAt(text.length() / 2));
        }
    }
}
