package _01_FirstStepsInCoding.MoreExercises;

import java.util.Scanner;

public class E06Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double skumriaPrice = Double.parseDouble(scanner.nextLine());
        double cacaPrice = Double.parseDouble(scanner.nextLine());
        double palamudKG = Double.parseDouble(scanner.nextLine());
        double safridKG = Double.parseDouble(scanner.nextLine());
        double midiKG = Double.parseDouble(scanner.nextLine());

        double palamudPrice = skumriaPrice + skumriaPrice * 0.6;
        double safridPrice = cacaPrice + cacaPrice * 0.8;
        double midiPrice = 7.50;

        double seafoodPrice = palamudPrice * palamudKG + safridPrice * safridKG + midiPrice * midiKG;
        System.out.printf("%.2f", seafoodPrice);
    }
}
