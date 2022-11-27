package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E07_FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFuel = scanner.nextLine();
        double litersFuelInReservoir = Double.parseDouble(scanner.nextLine());

        if (!typeOfFuel.equals("Diesel") && !typeOfFuel.equals("Gasoline") && !typeOfFuel.equals("Gas")) {
            System.out.println("Invalid fuel!");
        } else if (litersFuelInReservoir >= 25) {
            if (typeOfFuel.equals("Diesel")) {
                System.out.println("You have enough diesel.");
            } else if (typeOfFuel.equals("Gasoline")) {
                System.out.println("You have enough gasoline.");
            } else if (typeOfFuel.equals("Gas")) {
                System.out.println("You have enough gas.");
            }
        } else if (litersFuelInReservoir < 25) {
            if (typeOfFuel.equals("Diesel")) {
                System.out.println("Fill your tank with diesel!");
            } else if (typeOfFuel.equals("Gasoline")) {
                System.out.println("Fill your tank with gasoline!");
            } else if (typeOfFuel.equals("Gas")) {
                System.out.println("Fill your tank with gas!");
            }
        }
    }
}
