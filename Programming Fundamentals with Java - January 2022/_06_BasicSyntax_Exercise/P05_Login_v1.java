package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P05_Login_v1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String password = scanner.nextLine();
        int nameLength = name.length();

        int counter = 0;
        boolean isCorrect = false;
        while (true) {
            int passwordLength = password.length();
            if (nameLength == passwordLength) {
                for (int i = 0; i < nameLength; i++) {
                    char currentNameSymbol = name.charAt(i);
                    char currentPassSymbol = password.charAt(passwordLength - 1 - i);
                    if (currentNameSymbol != currentPassSymbol) {
                        counter++;
                        break;
                    }
                    isCorrect = true;
                }
            } else {
                counter++;
            }
            if (counter >= 4) {
                System.out.printf("User %s blocked!", name);
                break;
            }
            if (isCorrect) {
                System.out.printf("User %s logged in.", name);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
            password = scanner.nextLine();
        }
    }
}
