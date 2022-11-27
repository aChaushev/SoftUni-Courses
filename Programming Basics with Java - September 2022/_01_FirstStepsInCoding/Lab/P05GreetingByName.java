package _01_FirstStepsInCoding.Lab;

import java.util.Scanner;

public class P05GreetingByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
