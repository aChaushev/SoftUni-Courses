package _04_WorkingWith_Abstraction_Exercise._01_CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine() + ":");
        for (CardSuits cardSuits: CardSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",cardSuits.ordinal(),cardSuits.name());
        }

    }
}
