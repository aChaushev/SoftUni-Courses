package _03_ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P11_FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        boolean workDays = dayOfWeek.equals("Monday") ||
                dayOfWeek.equals("Tuesday") ||
                dayOfWeek.equals("Wednesday") ||
                dayOfWeek.equals("Thursday") ||
                dayOfWeek.equals("Friday");
        boolean weekend = dayOfWeek.equals("Saturday") ||
                dayOfWeek.equals("Sunday");

        boolean inValid = false;
        double price = 0;
        if (workDays) {
            //banana	apple	orange	grapefruit	kiwi	pineapple	grapes
            //2.50	    1.20	0.85	1.45	    2.70	5.50	    3.85
            if (fruit.equals("banana")) {
                price = 2.50;
            } else if (fruit.equals("apple")) {
                price = 1.20;
            } else if (fruit.equals("orange")) {
                price = 0.85;
            } else if (fruit.equals("grapefruit")) {
                price = 1.45;
            } else if (fruit.equals("kiwi")) {
                price = 2.70;
            } else if (fruit.equals("pineapple")) {
                price = 5.50;
            } else if (fruit.equals("grapes")) {
                price = 3.85;
            } else {
                inValid = true;
            }

        } else if (weekend) {
            //banana	apple	orange	grapefruit	kiwi	pineapple	grapes
            //2.70	    1.25	0.90	1.60	    3.00	5.60	    4.20
            if (fruit.equals("banana")) {
                price = 2.70;
            } else if (fruit.equals("apple")) {
                price = 1.25;
            } else if (fruit.equals("orange")) {
                price = 0.90;
            } else if (fruit.equals("grapefruit")) {
                price = 1.60;
            } else if (fruit.equals("kiwi")) {
                price = 3.00;
            } else if (fruit.equals("pineapple")) {
                price = 5.60;
            } else if (fruit.equals("grapes")) {
                price = 4.20;
            } else {
                inValid = true;
            }
        } else {
            inValid = true;
        }

        if (inValid) {
            System.out.println("error");
        } else {
            double totalCost = price * quantity;
            System.out.printf("%.2f",totalCost);
        }
    }
}
