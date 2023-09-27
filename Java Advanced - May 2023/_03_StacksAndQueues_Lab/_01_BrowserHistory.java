package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String currentURL = null;

        Deque<String> history = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (history.isEmpty()) { // ако комадната е "back" и нямаме история
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentURL = history.pop(); //ако имаме история последния в history става текущ URL и премахваме URL от history
                }

            } else {                            // при получаване на нов URL
                if (currentURL != null) {       // ако имаме текущ URL го добавяме в историята
                    history.push(currentURL);
                }
                currentURL = input;             // новия URL става текущ
            }

            System.out.println(currentURL);

            input = scanner.nextLine();
        }
    }
}
