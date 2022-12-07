package _08_DataTypesAndVariables_Lab;

import java.util.Scanner;

public class P05_ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String symbol = scanner.nextLine();
        String result = String.format("%s%s%s", firstName, symbol, secondName);
        System.out.println(result);
    }
}
