package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String password = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            char currentSymbol = name.charAt(i);
            password += currentSymbol;
        }
        int counter = 0;
        String input = scanner.nextLine();
        while (!input.equals(password)) {
            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", name);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }

        if (input.equals(password)) {
            System.out.printf("User %s logged in.", name);
        }
    }
}
