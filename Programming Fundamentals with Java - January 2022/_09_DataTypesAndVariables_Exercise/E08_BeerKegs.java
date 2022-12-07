package _09_DataTypesAndVariables_Exercise;

import java.util.Scanner;

public class E08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLines = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        double maxVolume = Double.MIN_VALUE;
        for (int i = 1; i <= inputLines; i++) {
            String kegModel = scanner.nextLine();
            double kegRadius = Double.parseDouble(scanner.nextLine());
            int kegHeight = Integer.parseInt(scanner.nextLine());
            double currentKegVolume = Math.PI * Math.pow(kegRadius, 2) * kegHeight;
            if (currentKegVolume > maxVolume) {
                maxVolume = currentKegVolume;
                biggestKeg = kegModel;
            }
        }
        System.out.println(biggestKeg);
    }
}
