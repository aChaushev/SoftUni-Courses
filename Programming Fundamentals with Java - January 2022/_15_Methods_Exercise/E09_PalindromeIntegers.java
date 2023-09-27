package _15_Methods_Exercise;

import java.util.Scanner;

public class E09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            System.out.println(isPalindrome(command));
            command = scanner.nextLine();
        }

    }

    public static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
