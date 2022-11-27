package _01_FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P09YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double greenArea = Double.parseDouble(scanner.nextLine());

        double greenAreaPrice = greenArea * 7.61;
        double discount = greenAreaPrice * 0.18;
        double finalPrice = greenAreaPrice - discount;

        System.out.printf("The final price is: %.2f lv.%n", finalPrice);
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}