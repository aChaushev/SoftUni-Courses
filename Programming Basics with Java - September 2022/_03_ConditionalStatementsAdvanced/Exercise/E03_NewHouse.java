package _03_ConditionalStatementsAdvanced.Exercise;

import java.util.Scanner;

public class E03_NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Вид цветя - текст с възможности - "Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        //•	Брой цветя - цяло число в интервала [10…1000]
        //•	Бюджет - цяло число в интервала [50…2500]

        String kindOfFlowers = scanner.nextLine();
        int flowersNum = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        //Roses", "Dahlias", "Tulips", "Narcissus", "Gladiolus"
        double totalPrice = 0;
        switch (kindOfFlowers) {
            case "Roses":
                totalPrice = flowersNum * 5;
                if (flowersNum > 80) {
                    totalPrice = totalPrice - totalPrice * 0.10;
                }
                break;
            case "Dahlias":
                totalPrice = flowersNum * 3.8;
                if (flowersNum > 90) {
                    totalPrice = totalPrice - totalPrice * 0.15;
                }
                break;
            case "Tulips":
                totalPrice = flowersNum * 2.8;
                if (flowersNum > 80) {
                    totalPrice = totalPrice - totalPrice * 0.15;
                }
                break;
            case "Narcissus":
                totalPrice = flowersNum * 3;
                if (flowersNum < 120) {
                    totalPrice = totalPrice + totalPrice * 0.15;
                }
                break;
            case "Gladiolus":
                totalPrice = flowersNum * 2.5;
                if (flowersNum < 80) {
                    totalPrice = totalPrice + totalPrice * 0.20;
                }
                break;
        }
        //•	Ако бюджета им е достатъчен -
        // "Hey, you have a great garden with {броя цвета} {вид цветя} and {останалата сума} leva left."
        //•	Ако бюджета им е НЕ достатъчен -
        // "Not enough money, you need {нужната сума} leva more."
        double diffPrice = Math.abs(budget - totalPrice);
        if (budget >= totalPrice) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left."
                    , flowersNum, kindOfFlowers, diffPrice);
        } else if (budget < totalPrice) {
            System.out.printf("Not enough money, you need %.2f leva more.", diffPrice);
        }
    }
}
