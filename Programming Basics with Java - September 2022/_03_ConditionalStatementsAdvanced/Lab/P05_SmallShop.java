package _03_ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P05_SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        град / 	coffee	water	beer	sweets	peanuts
//        Sofia	    0.50	0.80	1.20	1.45	1.60
//        Plovdiv	0.40	0.70	1.15	1.30	1.50
//        Varna	    0.45	0.70	1.10	1.35	1.55

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;
        //Sofia	    0.50	0.80	1.20	1.45	1.60
        if (city.equals("Sofia")) {
            if (product.equals("coffee")) {
                price = 0.50;
            } else if (product.equals("water")) {
                price = 0.80;
            } else if (product.equals("beer")) {
                price = 1.20;
            } else if (product.equals("sweets")) {
                price = 1.45;
            } else if (product.equals("peanuts")) {
                price = 1.60;
            }
        } else if (city.equals("Plovdiv")) {
            //Plovdiv	0.40	0.70	1.15	1.30	1.50
            if (product.equals("coffee")) {
                price = 0.40;
            } else if (product.equals("water")) {
                price = 0.70;
            } else if (product.equals("beer")) {
                price = 1.15;
            } else if (product.equals("sweets")) {
                price = 1.30;
            } else if (product.equals("peanuts")) {
                price = 1.50;
            }
        } else if (city.equals("Varna")) {
            //Varna	    0.45	0.70	1.10	1.35	1.55
            if (product.equals("coffee")) {
                price = 0.45;
            } else if (product.equals("water")) {
                price = 0.70;
            } else if (product.equals("beer")) {
                price = 1.10;
            } else if (product.equals("sweets")) {
                price = 1.35;
            } else if (product.equals("peanuts")) {
                price = 1.55;
            }
        }
        System.out.println(price * quantity);
    }
}
