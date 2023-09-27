package _04_WorkingWith_Abstraction_Exercise._03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRanks cardRank = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuits = CardSuits.valueOf(scanner.nextLine());
        int cardPower = cardRank.getPower() + cardSuits.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuits, cardPower);

    }
}
