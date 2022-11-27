package _05_WhileLoop.Lab;

import java.util.Scanner;

public class P07_MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int minNum =Integer.MAX_VALUE;
        while (!input.equals("Stop")) {
            int currentNum = Integer.parseInt(input);
            if (currentNum < minNum) {
                minNum = currentNum;
            }
            input = scanner.nextLine();
        }
        if (minNum != Integer.MAX_VALUE) {
            System.out.println(minNum);
        }

    }
}
