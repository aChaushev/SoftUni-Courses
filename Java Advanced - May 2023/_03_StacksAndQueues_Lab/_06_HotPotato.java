package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");
        Deque<String> kindsQueue = new ArrayDeque<>();
        int steps = Integer.parseInt(scanner.nextLine());

        for (String kid : namesArr) {
            kindsQueue.offer(kid);
        }

        while (kindsQueue.size() > 1){
            for (int i = 1; i < steps; i++) {
                String currentKid = kindsQueue.poll();
                kindsQueue.offer(currentKid);
            }

            String removedKid = kindsQueue.poll();
            System.out.println("Removed " + removedKid);
        }
        System.out.println("Last is " + kindsQueue.peek());
    }
}
