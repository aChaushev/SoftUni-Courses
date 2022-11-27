package PB_Exams.Exam_02_6and7April2019;

import java.util.Scanner;

public class E04_CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Стойността на ваучера – цяло число в интервала [1…100000]
        //След това до получаване на команда "End" или до изчерпването на ваучера, се чете по един ред:
        //o	Покупката, която Любо е избрал – текст
        int voucher = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int allExpenses = voucher;
        int movieTickets = 0;
        int otherPurchases = 0;
        while (!input.equals("End")) {
            int currentPrice = 0;
            if (input.length() > 8) {
                currentPrice += input.charAt(0) + input.charAt(1);
                if (currentPrice <= allExpenses) {
                    movieTickets++;
                    allExpenses -= currentPrice;
                } else {
                    break;
                }
            } else {
                currentPrice += input.charAt(0);
                if (currentPrice <= allExpenses) {
                    otherPurchases++;
                    allExpenses -= currentPrice;
                } else {
                    break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(movieTickets);
        System.out.println(otherPurchases);
    }
}
