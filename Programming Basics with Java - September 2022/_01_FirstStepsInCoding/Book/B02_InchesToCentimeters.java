package _01_FirstStepsInCoding.Book;

import java.util.Scanner;

public class B02_InchesToCentimeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inches = ");
        double inches = Double.parseDouble(scanner.nextLine());
        double result = inches * 2.54;
        System.out.println("Centimeters = " + result);
    }
}
