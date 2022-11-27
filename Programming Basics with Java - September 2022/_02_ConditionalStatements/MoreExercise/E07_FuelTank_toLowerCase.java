package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E07_FuelTank_toLowerCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFuel = scanner.nextLine();
        double litersFuelInReservoir = Double.parseDouble(scanner.nextLine());

        if (!typeOfFuel.equals("Diesel") && !typeOfFuel.equals("Gasoline") && !typeOfFuel.equals("Gas")) {
            System.out.println("Invalid fuel!");
        } else if (litersFuelInReservoir >= 25) {
            System.out.printf("You have enough %s.", typeOfFuel.toLowerCase());
        } else if (litersFuelInReservoir < 25) {
            System.out.printf("Fill your tank with %s!", typeOfFuel.toLowerCase());
        }
    }
}

