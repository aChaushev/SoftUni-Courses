package _05_WhileLoop.MoreExercise;

import java.util.Scanner;

public class E03_StreamOfLetters_OnlyWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String digit = scanner.nextLine();

        String word = "";
        String command = "";
        while (!digit.equals("End")) {
            char letter = digit.charAt(0);
            if (letter == 'n' && !command.contains("n")) {
                command += letter;
            } else if (letter == 'o' && !command.contains("o")) {
                command += letter;
            } else if (letter == 'c' && !command.contains("c")) {
                command += letter;
            } else if ((65 <= digit.charAt(0) && digit.charAt(0) <= 90) || (97 <= digit.charAt(0) && digit.charAt(0) <= 122)) {
                word += letter;
            }
            if (command.contains("c") && command.contains("o") && command.contains("n")) {
                System.out.print(word);
                System.out.print(" ");
                word = "";
                command = "";
            }
            digit = scanner.nextLine();
        }
    }
}
