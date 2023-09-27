package _04_StacksAndQueues_Exercise;

import java.util.Scanner;

public class _06_RecursiveFibonacci_1 {
    // Algorithmic complexity O(2^n)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long result = fibonacci(n);
        System.out.println(result);

    }

    public static long fibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
