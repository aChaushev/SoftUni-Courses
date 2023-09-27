package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _08_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<String> historyStack = new ArrayDeque<>();
        Deque<String> forwardStack = new ArrayDeque<>();
        String currentURL = null;

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (historyStack.isEmpty()) { // ако комадната е "back" и нямаме история
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {                               //ако имаме история
                    forwardStack.push(currentURL);     //текущ URL отива в forwardStack
                    currentURL = historyStack.peek();  //последния в historyStack става текущ URL
                    historyStack.pop(); // премахваме последния URL от historyStack
                }
            } else if (input.equals("forward")) {
                if (forwardStack.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {    //ако имаме предни URL т.е. ползвалисме back преди това и сме добавяли във forwardStack
                    historyStack.push(currentURL);  //текущ URL отива в historyStack
                    currentURL = forwardStack.peek(); //последния в forwardStack става текущ URL
                    forwardStack.pop(); // премахваме последния URL от forwardStack
                }

            } else {                            // при получаване на нов URL
                forwardStack.clear();
                if (currentURL != null) {        // ако имаме текущ URL го добавяме в историята
                    historyStack.push(currentURL);
                }
                currentURL = input;             // новия URL става текущ

            }
            System.out.println(currentURL);
            input = scanner.nextLine();
        }
    }
}
