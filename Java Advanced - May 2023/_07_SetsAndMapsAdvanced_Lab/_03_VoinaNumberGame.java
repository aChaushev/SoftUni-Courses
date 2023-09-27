package _07_SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _03_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {

            int firstCard = firstSet.iterator().next();
            firstSet.remove(firstCard);

            int secondCard = secondSet.iterator().next();
            secondSet.remove(secondCard);

            if (firstCard > secondCard) {
                firstSet.add(firstCard);
                firstSet.add(secondCard);
            } else if (firstCard < secondCard) {
                secondSet.add(firstCard);
                secondSet.add(secondCard);
            }

            if (firstSet.isEmpty() || secondSet.isEmpty()) {
                break;
            }

        }

        if (firstSet.size() > secondSet.size()) {
            System.out.println("First player win!");
        } else if (firstSet.size() < secondSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
