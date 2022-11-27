package _01_FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class E06_Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int plastic = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double materials = (plastic + 2) * 1.5 + (paint + paint * 0.1) * 14.50 + thinner * 5 + 0.40;
        double cost = materials + 0.3 * materials * hours;
        System.out.println(cost);
    }
}
