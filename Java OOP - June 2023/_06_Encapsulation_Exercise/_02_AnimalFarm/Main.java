package _06_Encapsulation_Exercise._02_AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
