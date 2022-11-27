package _03_ConditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class P03_AnimalType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String animal = scanner.nextLine();

        //•	dog -> mammal
        //•	crocodile, tortoise, snake -> reptile
        //•	others -> unknown

        switch (animal) {
            case "dog":
                System.out.println("mammal");
                break;
            case "crocodile":
            case "tortoise":
            case "snake":
                System.out.println("reptile");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
