package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");
        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {
            if (i == 0) {
                numbersStack.push(Integer.parseInt(inputArr[i]));
                continue;
            }
            if (i % 2 == 0) {
                int currentNum = Integer.parseInt(inputArr[i]);
                int stackNum = numbersStack.peek();
                numbersStack.pop();
                if (inputArr[i - 1].equals("+")) {
                    numbersStack.push(stackNum + currentNum);
                } else if (inputArr[i - 1].equals("-")) {
                    numbersStack.push(stackNum - currentNum);
                }
            }
        }
        System.out.println(numbersStack.peek());
    }
}
