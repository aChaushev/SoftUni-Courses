package _01_FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class E04_VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetablesPrice = Double.parseDouble(scanner.nextLine());
        double fruitsPrice = Double.parseDouble(scanner.nextLine());
        int vegKG = Integer.parseInt(scanner.nextLine());
        int fruitsKG = Integer.parseInt(scanner.nextLine());

        double vegetables = vegetablesPrice * vegKG;
        double fruits = fruitsPrice * fruitsKG;
        double finalPrice = (vegetables + fruits) / 1.94;
        System.out.printf("%.2f", finalPrice);
    }
}
