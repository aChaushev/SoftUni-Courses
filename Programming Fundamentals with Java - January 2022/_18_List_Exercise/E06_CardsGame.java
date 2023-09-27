package _18_List_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
            int firstDeckCard = firstDeck.get(0);
            int secondDeckCard = secondDeck.get(0);
            if (firstDeckCard > secondDeckCard) {
                firstDeck.add(secondDeckCard);
                secondDeck.remove(0);
                firstDeck.add(firstDeckCard);
                firstDeck.remove(0);
            } else if (firstDeckCard < secondDeckCard) {
                secondDeck.add(firstDeckCard);
                firstDeck.remove(0);
                secondDeck.add(secondDeckCard);
                secondDeck.remove(0);
            } else if (firstDeckCard == secondDeckCard) {
                firstDeck.remove(0);
                secondDeck.remove(0);
            }
        }
        if (firstDeck.size() > 0) {
            System.out.println("First player wins! Sum: " + deckSum(firstDeck));
        } else if (secondDeck.size() > 0) {
            System.out.println("Second player wins! Sum: " + deckSum(secondDeck));
        }
    }

    private static int deckSum(List<Integer> deck) {
        int deckSum = 0;
        for (int element : deck) {
            deckSum += element;
        }
        return deckSum;
    }
}
