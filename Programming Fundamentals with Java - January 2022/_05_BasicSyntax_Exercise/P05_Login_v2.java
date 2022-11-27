package _05_BasicSyntax_Exercise;

import java.util.Scanner;

public class P05_Login_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String password = "";
        int counter = 0;
        while (counter < 4) {
            String input = scanner.nextLine();
            for (int i = input.length() - 1; i >= 0; i--) {
                char currentSymbol = input.charAt(i);
                password += currentSymbol;
            }
            if (name.equals(password)) {
                System.out.printf("User %s logged in.", name);
                break;
            } else {
                counter++;
                if (counter >= 4) {
                    System.out.printf("User %s blocked!", name);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            }
            password = "";
        }
    }
}