package _04_StacksAndQueues_Exercise;

import java.util.*;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operationsArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementToAdd = operationsArr[0];
        int elementToRemove = operationsArr[1];
        int elementToFind = operationsArr[2];

        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> numbersQueue = new ArrayDeque<>();

        for (int i = 0; i < elementToAdd; i++) {
            numbersQueue.offer(inputLine[i]);
        }

        for (int i = 0; i < elementToRemove; i++) {
            numbersQueue.poll();
            if (numbersQueue.isEmpty()) {
                System.out.println(0);
                return;
            }
        }

        if (numbersQueue.contains(elementToFind)) {
            System.out.println("true");
        } else {
            int minNumber = Collections.min(numbersQueue);
            System.out.println(minNumber);
        }
    }
}
