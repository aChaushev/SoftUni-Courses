package PB_Exams.Exam_04_2and3May2019;

import java.util.Scanner;

public class E01_FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberriesPrice = Double.parseDouble(scanner.nextLine());
        double bananasQuantity = Double.parseDouble(scanner.nextLine());
        double orangeQuantity = Double.parseDouble(scanner.nextLine());
        double raspberriesQuantity = Double.parseDouble(scanner.nextLine());
        double strawberriesQuantity = Double.parseDouble(scanner.nextLine());

        double raspberriesPrice = strawberriesPrice / 2;
        double orangePrice = raspberriesPrice * 0.6;
        double bananasPrice = raspberriesPrice * 0.2;

        double totalPrice = strawberriesPrice * strawberriesQuantity + bananasQuantity * bananasPrice +
                orangeQuantity * orangePrice + raspberriesQuantity * raspberriesPrice;
        System.out.printf("%.2f", totalPrice);
    }
}
