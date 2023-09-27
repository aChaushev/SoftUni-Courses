package _03_StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {
                String output = printerQueue.isEmpty()
                        ? "Printer is on standby"           // тернарен оператор
                        : "Canceled " + printerQueue.poll();

                System.out.println(output);
            } else {
                printerQueue.offer(input);

            }

            input = scanner.nextLine();
        }

//        for (String file : printerQueue) {
//            System.out.println(file);
//        }
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}
