package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E06_FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Брой магнолии – цяло число в интервала [0 … 50]
        //•	Брой зюмбюли – цяло число в интервала [0 … 50]
        //•	Брой рози – цяло число в интервала [0 … 50]
        //•	Брой кактуси – цяло число в интервала [0 … 50]
        //•	Цена на подаръка – реално число в интервала [0.00 … 500.00]
        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinths = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cacti = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        //•	Магнолии – 3.25 лева
        //•	Зюмбюли – 4 лева
        //•	Рози – 3.50 лева
        //•	Кактуси – 8 лева

        double totalIncome = (magnolias * 3.25 + hyacinths * 4 + roses * 3.5 + cacti * 8) * 0.95;
        double diff = Math.abs(totalIncome - giftPrice);

        if (totalIncome >= giftPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(diff));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(diff));
        }
    }
}
