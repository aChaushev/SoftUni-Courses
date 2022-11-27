package _01_FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P04InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inches = Double.parseDouble(scanner.nextLine());
        double result = inches * 2.54;
        System.out.println(result);
    }
}
