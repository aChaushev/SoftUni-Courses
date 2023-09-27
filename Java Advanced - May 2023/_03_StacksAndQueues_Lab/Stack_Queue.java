package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Stack_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(13); // Adds element to the top of the stack
        stack.peek(); // returns the top element without removing it
        stack.pop(); // returns the top element and removes it

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(13); // Adds element to the end of the queue // или queue.add(13);
        queue.peek(); // returns the front(first) element without removing it
        queue.poll(); // returns the front(first) and removes it // или queue.remove();

        queue.offer(13);
        queue.offer(42);
        queue.offer(69);

        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }
}
