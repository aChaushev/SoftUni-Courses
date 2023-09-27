package _15_Methods_Exercise;

import java.util.Scanner;

public class E04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        if (isBetween6And10Chars(password) && consistOnlyLettersAndDigits(password) && haveAtLeast2Digits(password)) {
            System.out.println("Password is valid");
        } else {
            if (!isBetween6And10Chars(password)) {
                System.out.println("Password must be between 6 and 10 characters");
            }
            if (!consistOnlyLettersAndDigits(password)) {
                System.out.println("Password must consist only of letters and digits");
            }
            if (!haveAtLeast2Digits(password)) {
                System.out.println("Password must have at least 2 digits");
            }
        }

    }

    public static boolean isBetween6And10Chars(String input) {
        return 6 <= input.length() && input.length() <= 10;
    }

    public static boolean consistOnlyLettersAndDigits(String input) {
        input = input.toLowerCase();
        for (char symbol : input.toCharArray()) {
            if (!(48 <= symbol && symbol <= 57 || 97 <= symbol && symbol <= 122)) {
                return false;
            }
        }
        return true;
    }

    public static boolean haveAtLeast2Digits(String input) {
        int digitCnt = 0;
        for (char symbol : input.toCharArray()) {
            if (48 <= symbol && symbol <= 57) {
                digitCnt++;
            }
            if (digitCnt >= 2) {
                return true;
            }
        }
        return false;
    }
}
