package _04_StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isBalanced = true;
        Deque<Character> openBracketsStack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
                openBracketsStack.push(currentBracket);
            } else {
                if (openBracketsStack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpenBracket = openBracketsStack.pop();
                if ((currentBracket == ')' && lastOpenBracket != '(') ||
                        (currentBracket == ']' && lastOpenBracket != '[') ||
                        (currentBracket == '}' && lastOpenBracket != '{')) {
                    isBalanced = false;
                }
            }
        }
        if (isBalanced && openBracketsStack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
