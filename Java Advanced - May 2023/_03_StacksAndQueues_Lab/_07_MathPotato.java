package _03_StacksAndQueues_Lab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");
        PriorityQueue<String> kindsQueue = new PriorityQueue<>();
        int steps = Integer.parseInt(scanner.nextLine());

        for (String kid : namesArr) {
            kindsQueue.offer(kid);
        }
        int cycleCnt = 0;
        while (kindsQueue.size() > 1) {
            cycleCnt++;                     // брояч на циклите
            // превъртаме подаванията
            // взимаме детете от челна позиция и го поставяме на опашката
            // след for-a детето, което е на челна позиция е с "горещия картоф"
            for (int i = 1; i < steps; i++) {
                String currentKid = kindsQueue.poll();
                kindsQueue.offer(currentKid);
            }
            // проверка дали цикъла е Prime
            if (isPrime(cycleCnt)) {
                String primeKid = kindsQueue.peek();
                System.out.println("Prime " + primeKid);
            } else {
                String removedKid = kindsQueue.poll();
                System.out.println("Removed " + removedKid);
            }
        }
        System.out.println("Last is " + kindsQueue.peek());
    }

    private static boolean isPrime(int cycleCnt) {  // проверка дали цикъла е Prime
        if (cycleCnt <= 1) {
            return false;
        }
        // цикъла не включва 1 и самото число
        for (int j = 2; j < cycleCnt; j++) {
            if (cycleCnt % j == 0) {        // ако числото се дели на други числа (освен на едно и на себе си)
                return false;
            }
        }
        return true;   // ако числото се дели само на себе си (и на 1) e Prime

//          ВАРИАНТ ЗА ПРОВЕРКА НА PRIME
//        int counter = 0;                        // брояч на броя на възможните деления на числото
//        for (int j = 2; j <= cycleCnt; j++) {
//            if (cycleCnt % j == 0) {           // ако числото се дели само на себе си (и на 1)
//                counter++;
//            }
//        }
//        return counter == 1;                // ако числото се дели само на себе си (и на 1) e Prime
    }
}
