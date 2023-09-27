package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _03_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputDecimal = Integer.parseInt(scanner.nextLine());
        Deque<Integer> binaryStack = new ArrayDeque<>();
        if (inputDecimal == 0){
            System.out.println(0);
            return;
        }
        while (inputDecimal != 0) {
            binaryStack.push(inputDecimal % 2);
            inputDecimal /= 2;
        }

        for (Integer integer : binaryStack) {
            System.out.print(integer);
        }
    }
}
