package _01_FirstStepsInCoding.Exercise;

import java.util.Scanner;

public class E05_SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int detergent = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double sum = pens * 5.8 + markers * 7.2 + detergent * 1.2;
        double result = sum - (sum * discount * 0.01);

        System.out.println(result);
    }
}
