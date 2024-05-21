package ExamPreparations._05_JavaAdvancedRetakeExam_19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liliesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(liliesStack::push);

        Deque<Integer> rosesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(rosesQueue::offer);

        int wreathsCnt = 0;
        int storedFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int lastLilie = liliesStack.peek();
            int firstRose = rosesQueue.peek();
            int sum = lastLilie + firstRose;

            if (sum == 15) {
                wreathsCnt++;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (sum > 15) {
                liliesStack.push(liliesStack.pop() - 2);
            } else {
                liliesStack.pop();
                rosesQueue.poll();
                storedFlowers += sum;
            }
        }

        wreathsCnt += storedFlowers / 15;

        if (wreathsCnt >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", wreathsCnt);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", 5 - wreathsCnt);
        }

    }
}
