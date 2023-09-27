package _04_StacksAndQueues_Exercise;

import java.util.*;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCnt = Integer.parseInt(scanner.nextLine());

        Deque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < commandsCnt; i++) {
            String command = scanner.nextLine();
            if (command.contains("1")) {
                int numToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbersStack.push(numToAdd);

            } else if (command.equals("2")) {
                if (!numbersStack.isEmpty()) {
                    numbersStack.pop();
                }

            }
            if (command.equals("3")) {
                if (!numbersStack.isEmpty()) {
                    int maxNumber = Collections.max(numbersStack);
                    System.out.println(maxNumber);
                }
            }
        }

    }
}
