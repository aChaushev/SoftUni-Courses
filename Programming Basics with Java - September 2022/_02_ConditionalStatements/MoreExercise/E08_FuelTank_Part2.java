package _02_ConditionalStatements.MoreExercise;

import java.util.Scanner;

public class E08_FuelTank_Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double amountOfFuel = Double.parseDouble(scanner.nextLine());
        String ownClubCard = scanner.nextLine();

        double gasolinePrice = 2.22;
        double dieselPrice = 2.33;
        double gasPrice = 0.93;

        double totalFuelPrice = 0;
        if (ownClubCard.equals("No")) {
            if (fuelType.equals("Gasoline")) {
                totalFuelPrice = amountOfFuel * gasolinePrice;
            } else if (fuelType.equals("Diesel")) {
                totalFuelPrice = amountOfFuel * dieselPrice;
            } else if (fuelType.equals("Gas")) {
                totalFuelPrice = amountOfFuel * gasPrice;
            }
        } else if (ownClubCard.equals("Yes")) {
            gasolinePrice -= 0.18;
            dieselPrice -= 0.12;
            gasPrice -= 0.08;
            if (fuelType.equals("Gasoline")) {
                totalFuelPrice = amountOfFuel * gasolinePrice;
            } else if (fuelType.equals("Diesel")) {
                totalFuelPrice = amountOfFuel * dieselPrice;
            } else if (fuelType.equals("Gas")) {
                totalFuelPrice = amountOfFuel * gasPrice;
            }
        }

        if (20 <= amountOfFuel && amountOfFuel <= 25) {
            totalFuelPrice -= totalFuelPrice * 0.08;
        } else if (amountOfFuel > 25) {
            totalFuelPrice -= totalFuelPrice * 0.10;
        }
        System.out.printf("%.2f lv.", totalFuelPrice);
    }
}