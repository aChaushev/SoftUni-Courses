package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballsN = Integer.parseInt(scanner.nextLine());

        String maxSnowballData = "";
        double maxSnowballValue = Integer.MIN_VALUE;
        for (int i = 1; i <= snowballsN; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow((snowballSnow * 1.0 / snowballTime), snowballQuality);
            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                maxSnowballData = String.format("%d : %d = %.0f (%d)"
                        , snowballSnow, snowballTime, snowballValue, snowballQuality);
            }
        }
        System.out.println(maxSnowballData);
    }
}
