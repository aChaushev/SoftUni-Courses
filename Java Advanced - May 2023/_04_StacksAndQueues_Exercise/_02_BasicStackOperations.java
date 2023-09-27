package _04_StacksAndQueues_Exercise;

import java.util.*;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLineArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numbersToPush = firstLineArr[0];
        int numbersToPop = firstLineArr[1];
        int numberToFind = firstLineArr[2];
        int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
            numbersStack.push(inputArr[i]);
        }


        for (int i = 0; i < numbersToPop; i++) {
            numbersStack.pop();
            if (numbersStack.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
//        int minNum = Integer.MAX_VALUE;
//        boolean isFound = false;
//        for (Integer number : numbersStack) {
//            if (number < minNum) {
//                minNum = number;
//            }
//            if (number == numberToFind) {
//                isFound = true;
//                System.out.println(true);
//                break;
//            }
//        }
//        if (!isFound) {
//            System.out.println(minNum);
//        }
        if (numbersStack.contains(numberToFind)) {
            System.out.println(true);
        } else {
//            int minNum = Collections.min(numbersStack);
            int minNum = numbersStack.stream().mapToInt(e -> e).min().getAsInt();
            System.out.println(minNum);
        }
    }
}
