package _04_StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> numbersStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(e -> numbersStack.push(e));

//        for (Integer integer : numbersStack) {
//            System.out.print(integer + " ");
//        }
        while (!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
