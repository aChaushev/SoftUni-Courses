package PB_Exams.Exam_01_6and7July2019;

import java.util.Scanner;

public class E03_CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Първи ред - напитка - текст с възможности"Espresso", "Cappuccino" или "Tea"
        //•	Втори ред - захар - текст  с възможности "Without", "Normal" или "Extra"
        //•	Трети ред - брой напитки - цяло число в интервала [1… 50]
        String drinkType = scanner.nextLine();
        String sugarAmount = scanner.nextLine();
        int drinksNum = Integer.parseInt(scanner.nextLine());
        //•	При избрана напитка без захар има 35% отстъпка.
        //•	При избрана напитка "Espresso" и закупени поне 5 броя, има 25% отстъпка.
        //•	При сума надвишава 15 лева, 20% отстъпка от крайната цена,
        //	        Без захар	    Нормално	    Допълнително захар
        //Еспресо	0.90 лв./бр.	1 лв. /бр.	    1.20 лв. /бр.
        //Капучино	1.00 лв. /бр.	1.20 лв. /бр.	1.60 лв. /бр.
        //Чай	    0.50 лв. /бр.	0.60 лв. /бр.	0.70 лв. /бр.

        double drinkCost = 0;
        switch (drinkType) {
            case "Espresso":
                switch (sugarAmount) {
                    case "Without":
                        drinkCost = 0.9;
                        break;
                    case "Normal":
                        drinkCost = 1;
                        break;
                    case "Extra":
                        drinkCost = 1.2;
                        break;
                }
                break;
            case "Cappuccino":
                switch (sugarAmount) {
                    case "Without":
                        drinkCost = 1;
                        break;
                    case "Normal":
                        drinkCost = 1.2;
                        break;
                    case "Extra":
                        drinkCost = 1.6;
                        break;
                }
                break;
            case "Tea":
                switch (sugarAmount) {
                    case "Without":
                        drinkCost = 0.5;
                        break;
                    case "Normal":
                        drinkCost = 0.6;
                        break;
                    case "Extra":
                        drinkCost = 0.7;
                        break;
                }
                break;
        }
        double allDrinksCost = drinkCost * drinksNum;
        if (sugarAmount.equals("Without")) {
            allDrinksCost -= allDrinksCost * 0.35;
        }
        if (drinkType.equals("Espresso") && drinksNum > 5) {
            allDrinksCost -= allDrinksCost * 0.25;
        }
        if (allDrinksCost > 15) {
            allDrinksCost -= allDrinksCost * 0.2;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", drinksNum, drinkType, allDrinksCost);
    }
}
