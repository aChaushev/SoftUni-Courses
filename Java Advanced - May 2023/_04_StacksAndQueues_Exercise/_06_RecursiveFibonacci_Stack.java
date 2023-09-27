package _04_StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _06_RecursiveFibonacci_Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> fibonacciStack = new ArrayDeque<>();

        fibonacciStack.push(0l);
        fibonacciStack.push(1l);

        if (n < 2) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long num1 = fibonacciStack.pop();
            long num2 = fibonacciStack.pop();
            fibonacciStack.push(num1);
            fibonacciStack.push(num1 + num2);
        }
        System.out.println(fibonacciStack.pop());
    }
}
