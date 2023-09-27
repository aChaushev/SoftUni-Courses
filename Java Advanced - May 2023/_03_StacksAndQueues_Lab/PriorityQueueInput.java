package _03_StacksAndQueues_Lab;

import java.util.*;

public class PriorityQueueInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "23 43 15 8";

        Deque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(n -> queue.offer(n));

        PriorityQueue<Integer> priorQueue = new PriorityQueue<>(Comparator.reverseOrder());
//        или
//        PriorityQueue<Integer> priorQueue = new PriorityQueue<>((f, s) -> Integer.compare(s, f));

        System.out.println("Queue order: ");

        for (Integer integer : queue) {
            System.out.println(integer);
            priorQueue.offer(integer);
        }

        System.out.println("Priority queue order: ");

        while (!priorQueue.isEmpty()){
            System.out.println(priorQueue.poll());
        }
    }
}
