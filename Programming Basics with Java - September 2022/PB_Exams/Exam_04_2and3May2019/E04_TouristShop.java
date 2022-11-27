package PB_Exams.Exam_04_2and3May2019;

import java.util.Scanner;

public class E04_TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String productName = scanner.nextLine();

        int productsCnt = 0;
        double totalPrice = 0;
        while (!productName.equals("Stop")) {
            double productPrice = Double.parseDouble(scanner.nextLine());
            productsCnt++;
            if (productsCnt % 3 == 0) {
                productPrice /= 2;
            }
            if (totalPrice + productPrice > budget) {
                totalPrice += productPrice;
                break;
            }
            totalPrice += productPrice;

            productName = scanner.nextLine();
        }

        if (productName.equals("Stop")) {
            System.out.printf("You bought %d products for %.2f leva.", productsCnt, totalPrice);
        } else {
            System.out.println("You don't have enough money!");
            System.out.printf("You need %.2f leva!", totalPrice - budget);
        }
    }
}
