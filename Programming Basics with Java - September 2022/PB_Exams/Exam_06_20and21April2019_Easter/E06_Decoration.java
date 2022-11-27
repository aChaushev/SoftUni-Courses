package PB_Exams.Exam_06_20and21April2019_Easter;

import java.util.Scanner;

public class E06_Decoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clients = Integer.parseInt(scanner.nextLine());

        double allBills = 0;
        for (int i = 1; i <= clients; i++) {
            String input = scanner.nextLine();
            int purchaseCnt = 0;
            double bill = 0;

            while (!input.equals("Finish")) {
                String purchase = input;
                purchaseCnt++;
                switch (purchase) {
                    case "basket":
                        bill += 1.5;
                        break;
                    case "wreath":
                        bill += 3.80;
                        break;
                    case "chocolate bunny":
                        bill += 7;
                        break;
                }
                input = scanner.nextLine();
            }
            if (purchaseCnt % 2 == 0) {
                bill *= 0.8;
            }
            System.out.printf("You purchased %d items for %.2f leva.%n", purchaseCnt, bill);
            allBills += bill;
        }
        System.out.printf("Average bill per client is: %.2f leva.", allBills / clients);
    }
}
