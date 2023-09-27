package _04_StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCnt = Integer.parseInt(scanner.nextLine());
        StringBuilder textSb = new StringBuilder();
        Deque<String> undoStack = new ArrayDeque<>();

        for (int i = 0; i < commandsCnt; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("1")) {
                String stringToAppend = command[1];
                undoStack.push(textSb.toString());
                textSb.append(stringToAppend);

            } else if (command[0].equals("2")) {
                int lastCntToErase = Integer.parseInt(command[1]);
                if (lastCntToErase > textSb.length()) {
                    continue;
                }
                undoStack.push(textSb.toString());
                textSb.delete(textSb.length() - lastCntToErase, textSb.length());


            } else if (command[0].equals("3")) {
                int index = Integer.parseInt(command[1]);
                if (index > textSb.length() || index < 0) {
                    continue;
                }
                System.out.println(textSb.charAt(index - 1));

            } else if (command[0].equals("4")) {
                textSb = new StringBuilder(undoStack.pop());
            }
        }
    }
}
