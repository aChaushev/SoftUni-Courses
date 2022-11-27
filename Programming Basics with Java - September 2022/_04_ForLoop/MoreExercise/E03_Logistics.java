package _04_ForLoop.MoreExercise;

import java.util.Scanner;

public class E03_Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargoNum = Integer.parseInt(scanner.nextLine());

        double cargoCost = 0;
        int vanCargo = 0;
        int truckCargo = 0;
        int trainCargo = 0;
        for (int i = 1; i <= cargoNum; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());
            if (cargoWeight <= 3) {
                cargoCost += cargoWeight * 200;
                vanCargo += cargoWeight;
            } else if (cargoWeight <= 11) {
                cargoCost += cargoWeight * 175;
                truckCargo += cargoWeight;
            } else {
                cargoCost += cargoWeight * 120;
                trainCargo += cargoWeight;
            }
        }
        int cargoCount = vanCargo + truckCargo + trainCargo;
        System.out.printf("%.2f%n", cargoCost / cargoCount);
        System.out.printf("%.2f%%%n", vanCargo * 1.0 / cargoCount * 100);
        System.out.printf("%.2f%%%n", truckCargo * 1.0 / cargoCount * 100);
        System.out.printf("%.2f%%%n", trainCargo * 1.0 / cargoCount * 100);
    }
}
