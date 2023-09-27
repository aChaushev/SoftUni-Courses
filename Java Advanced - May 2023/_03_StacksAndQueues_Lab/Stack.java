package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Stack {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(13);
        stack.push(42);
        stack.push(69);

        int topElement = stack.pop();

        System.out.println(topElement);

        Integer peekedElement = stack.peek();

        System.out.println(peekedElement);

        System.out.println(stack.isEmpty());

        for (Integer integer : stack) {
            System.out.println(integer);
        }


    }
}