package PB_Exams.Exam_07_18and19July2020;

import java.util.Scanner;

public class E02_AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.	Цената на багаж над 20кг - реално число в диапазона [10.0…80.0]
        //2.	Килограми на багажа – реално число в диапазона [1.0…32.0]
        //3.	Дни до пътуването – цяло число в диапазона [1…60]
        //4.	Брой багажи – цяло число в диапазона [1…10]
        double luggagePriceOver20Kg = Double.parseDouble(scanner.nextLine());
        double luggageKg = Double.parseDouble(scanner.nextLine());
        int daysUntilTravel = Integer.parseInt(scanner.nextLine());
        int luggageCnt = Integer.parseInt(scanner.nextLine());

        double luggagePrice = 0;
        if (luggageKg < 10) {
            luggagePrice = luggagePriceOver20Kg * 0.2;
        } else if (luggageKg <= 20) {
            luggagePrice = luggagePriceOver20Kg * 0.5;
        } else {
            luggagePrice = luggagePriceOver20Kg;
        }
        if (daysUntilTravel < 7) {
            luggagePrice *= 1.4;
        } else if (daysUntilTravel <= 30) {
            luggagePrice *= 1.15;
        } else {
            luggagePrice *= 1.1;
        }
        double totalPrice = luggagePrice * luggageCnt;
        System.out.printf("The total price of bags is: %.2f lv.", totalPrice);
    }
}
