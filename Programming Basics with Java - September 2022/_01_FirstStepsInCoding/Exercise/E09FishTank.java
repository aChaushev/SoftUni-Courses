package _01_FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class E09FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentOut = Double.parseDouble(scanner.nextLine());

        double volumeDm = length * 0.1 * width * 0.1 * height * 0.1;
        double waterVolume = volumeDm - (volumeDm * percentOut * 0.01);
        System.out.println(waterVolume);
    }
}
