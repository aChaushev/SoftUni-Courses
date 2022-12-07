package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pourNum = Integer.parseInt(scanner.nextLine());
        int litersInTank = 0;
        for (int i = 1; i <= pourNum; i++) {
            int litersOfWater = Integer.parseInt(scanner.nextLine());
            if (litersInTank + litersOfWater > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                litersInTank += litersOfWater;
            }
        }
        System.out.println(litersInTank);
    }
}
