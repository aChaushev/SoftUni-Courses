package _01_FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class E07_FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int veg = Integer.parseInt(scanner.nextLine());

        double account = chicken * 10.35 + fish * 12.40 + veg * 8.15;
        double finalPrice = account + account * 0.2 + 2.50;

        System.out.println(finalPrice);
    }
}
