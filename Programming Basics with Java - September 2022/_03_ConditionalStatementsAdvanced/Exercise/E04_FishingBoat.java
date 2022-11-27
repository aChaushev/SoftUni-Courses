package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E04_FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Бюджет на групата – цяло число в интервала [1…8000]
        //•	Сезон –  текст : "Spring", "Summer", "Autumn", "Winter"
        //•	Брой рибари – цяло число в интервала [4…18]

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermanNum = Integer.parseInt(scanner.nextLine());

        //Цената зависи от сезона:
        //•	Цената за наем на кораба през пролетта е  3000 лв.
        //•	Цената за наем на кораба през лятото и есента е  4200 лв.
        //•	Цената за наем на кораба през зимата е  2600 лв.
        //В зависимост от броя си групата ползва отстъпка:
        //•	Ако групата е до 6 човека включително  –  отстъпка от 10%.
        //•	Ако групата е от 7 до 11 човека включително  –  отстъпка от 15%.
        //•	Ако групата е от 12 нагоре  –  отстъпка от 25%.
        //Рибарите ползват допълнително 5% отстъпка ако са четен брой освен ако не е есен - тогава нямат допълнителна отстъпка.

        double totalPrice = 0;
        switch (season) {
            case "Spring":
                totalPrice = 3000;
                break;
            case "Summer":
            case "Autumn":
                totalPrice = 4200;
                break;
            case "Winter":
                totalPrice = 2600;
                break;
        }
        boolean smallGroup = fishermanNum <= 6;
        boolean averageGroup = 7 <= fishermanNum && fishermanNum <= 11;
        boolean largeGroup = fishermanNum > 12;

        if (smallGroup) {
            totalPrice = totalPrice - totalPrice * 0.1;
        } else if (averageGroup) {
            totalPrice = totalPrice - totalPrice * 0.15;
        } else if (largeGroup) {
            totalPrice = totalPrice - totalPrice * 0.25;
        }

        if (fishermanNum % 2 == 0 && !(season.equals("Autumn"))) {
            totalPrice = totalPrice - totalPrice * 0.05;
        }
        //•	Ако бюджетът е достатъчен:
        //"Yes! You have {останалите пари} leva left."
        //•	Ако бюджетът НЕ Е достатъчен:
        //"Not enough money! You need {сумата, която не достига} leva."

        double diff = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else if (budget < totalPrice) {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}
