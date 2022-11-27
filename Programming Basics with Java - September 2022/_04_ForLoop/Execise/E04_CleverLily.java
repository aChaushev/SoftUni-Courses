package _04_ForLoop.Execise;

import java.util.Scanner;

public class E04_CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Възрастта на Лили - цяло число в интервала [1...77]
        //•	Цената на пералнята - число в интервала [1.00...10 000.00]
        //•	Единична цена на играчка - цяло число в интервала [0...40]
        int liliAge = Integer.parseInt(scanner.nextLine());
        double wmPrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());

        double money = 0;
        int evenBDays = 0;
        for (int i = 1; i <= liliAge; i++) {

            if (i % 2 == 0) {
                evenBDays++;                       // money = money + 10;
                money += 10 * evenBDays;    //allMoney = allMoney + money;
            } else {
                money += toyPrice;
            }
        }
        money = money - evenBDays;
        double diff = Math.abs(money - wmPrice);

        if (money >= wmPrice) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}
