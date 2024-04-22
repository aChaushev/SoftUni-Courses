package ExamPreparations._12_JavaAdvancedRetakeExam_15December2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        Deque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQueue::offer);

        int matchCnt = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int lastMale = malesStack.peek();
            int firstFemale = femalesQueue.peek();

            if (firstFemale <= 0) {
                femalesQueue.poll();
                continue;
            } else if (firstFemale % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (lastMale <= 0) {
                malesStack.pop();
                continue;
            } else if (lastMale % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (lastMale == firstFemale) {
                matchCnt++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                malesStack.pop();
                femalesQueue.poll();
                malesStack.push(lastMale - 2);
            }

        } // WHILE END

        System.out.printf("Matches: %d\n", matchCnt);
        printDequeResult(malesStack,"Males");
        printDequeResult(femalesQueue,"Females");

    }

    private static void printDequeResult(Deque<Integer> deque, String prefix) {
        System.out.print(prefix + " left: ");
        if (deque.isEmpty()) {
            System.out.print("none");
        } else {
            System.out.print(deque.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        System.out.println();
    }
}
