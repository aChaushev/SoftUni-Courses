package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E06_TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 97; i < 97 + num; i++) {
            for (int j = 97; j < 97 + num; j++) {
                for (int k = 97; k < 97 + num; k++) {
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
