package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class StackInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(n -> stack.push(n));

        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
