package _01_FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class E08_BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int oneYearFee = Integer.parseInt(scanner.nextLine());

        double sneakers = oneYearFee - oneYearFee * 0.4;
        double equipment = sneakers - sneakers * 0.2;
        double ball = equipment / 4;
        double accessories = ball / 5;

        double totalCost = oneYearFee + sneakers + equipment + ball + accessories;
        System.out.println(totalCost);
    }
}
