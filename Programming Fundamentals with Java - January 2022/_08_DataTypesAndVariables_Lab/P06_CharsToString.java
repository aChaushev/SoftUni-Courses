package _08_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class P06_CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        char thirdSymbol = scanner.nextLine().charAt(0);
        String result = String.format("%c%c%c", firstSymbol, secondSymbol, thirdSymbol);
        System.out.println(result);
    }
}
