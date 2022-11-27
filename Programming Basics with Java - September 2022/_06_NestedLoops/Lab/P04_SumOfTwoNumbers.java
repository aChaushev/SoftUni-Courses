package _06_NestedLoops.Lab;

import java.util.Scanner;

public class P04_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int count = 0;
        boolean validCombination = false;
        for (int i = firstNum; i <= secondNum; i++) {
            for (int j = firstNum; j <= secondNum; j++) {
                count++;
                int sum = i + j;
                if (sum == magicNum) {
                    validCombination = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", count, i, j, magicNum);
                    break;
                }
            }
            if (validCombination) {
                break;
            }
        }
        if (!validCombination) {
            System.out.printf("%d combinations - neither equals %d", count, magicNum);
        }
    }
}
