package _15_Methods_Exercise;

import java.util.Scanner;

public class E05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sum = numSum(firstNum, secondNum);
        int subtract = numSubtract(sum, thirdNum);
        System.out.println(subtract);
        // System.out.println(numSubtract(numSum(firstNum, secondNum),thirdNum));

    }

    public static int numSum(int n1, int n2) {
        return n1 + n2;
    }

    public static int numSubtract(int n1, int n2) {
        return n1 - n2;
    }
}
