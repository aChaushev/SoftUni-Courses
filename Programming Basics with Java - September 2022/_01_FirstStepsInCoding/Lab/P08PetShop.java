package _01_FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P08PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogsFoodPackage = Integer.parseInt(scanner.nextLine());
        int catsFoodPackage = Integer.parseInt(scanner.nextLine());

        double sum = dogsFoodPackage * 2.5 + catsFoodPackage * 4;

        System.out.printf("%.1f lv.", sum);
    }

}
