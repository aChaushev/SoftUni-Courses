package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int charactersNum = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= charactersNum; i++) {
            sum += scanner.nextLine().charAt(0);
//            char character = scanner.nextLine().charAt(0);
//            sum += (int) character;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
