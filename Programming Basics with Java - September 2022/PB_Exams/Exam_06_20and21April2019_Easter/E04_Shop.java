package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E04_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int eggsInShop = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int soldEggs = 0;
        boolean notEnoughEggs = false;
        while (!input.equals("Close")) {
            int eggsCnt = Integer.parseInt(scanner.nextLine());
            if (input.equals("Buy")) {
                if (eggsInShop - eggsCnt < 0) {
                    notEnoughEggs = true;
                    break;
                }
                eggsInShop -= eggsCnt;
                soldEggs += eggsCnt;
            } else if (input.equals("Fill")) {
                eggsInShop += eggsCnt;
            }
            input = scanner.nextLine();
        }
        if (notEnoughEggs) {
            System.out.println("Not enough eggs in store!");
            System.out.printf("You can buy only %d.", eggsInShop);
        } else {
            System.out.println("Store is closed!");
            System.out.printf("%d eggs sold.", soldEggs);
        }
    }
}
