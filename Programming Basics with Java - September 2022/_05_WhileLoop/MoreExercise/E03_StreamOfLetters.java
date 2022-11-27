package _05_WhileLoop.MoreExercise;

import java.util.Scanner;

public class E03_StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String digit = scanner.nextLine();

        int nCounter = 0;
        int oCounter = 0;
        int cCounter = 0;
        String word = "";
        while (!digit.equals("End")) {
            char letter = digit.charAt(0);
            if (digit.equals("n") && nCounter < 1) {
                nCounter++;
            } else if (digit.equals("o") && oCounter < 1) {
                oCounter++;
            } else if (digit.equals("c") && cCounter < 1) {
                cCounter++;
            } else if ((65 <= digit.charAt(0) && digit.charAt(0) <= 90) || (97 <= digit.charAt(0) && digit.charAt(0) <= 122)) {
                word = word + letter;
            }
            if (nCounter == 1 && oCounter == 1 && cCounter == 1) {
                nCounter = 0;
                oCounter = 0;
                cCounter = 0;
                System.out.print(word);
                System.out.print(" ");
                word = "";
            }
            digit = scanner.nextLine();
        }
    }
}
