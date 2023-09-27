package _08_SetsAndMapsAdvanced_Exercise;

import java.util.*;

public class _07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playersMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String[] playerInput = input.split("(: )|(, )");
            String player = playerInput[0];

            playersMap.putIfAbsent(player, new HashSet<>());

            Set<String> deckSet = playersMap.get(player);

            for (int i = 1; i < playerInput.length; i++) {
                String card = playerInput[i];
                deckSet.add(card);
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> playersPowerMap = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> player : playersMap.entrySet()) {
            int deckPower = 0;
            for (String card : player.getValue()) {
                int power = getCardPower(card);
                int type = getTypePower(card);
                deckPower += power * type;

            }
            playersPowerMap.putIfAbsent(player.getKey(), deckPower);
        }

        playersPowerMap.forEach((player, power) -> System.out.println(player + ": " + power));

    }

    private static int getCardPower(String card) {
        if (card.length() == 2) {
            char powerSymbol = card.charAt(0);
            int power;
            if (powerSymbol == 'J') {
                power = 11;
            } else if (powerSymbol == 'Q') {
                power = 12;
            } else if (powerSymbol == 'K') {
                power = 13;
            } else if (powerSymbol == 'A') {
                power = 14;
            } else {
                power = Integer.parseInt(String.valueOf(powerSymbol));
            }
            return power;
        } else {
            return 10;
        }
    }


    private static int getTypePower(String card) {
        char typeSymbol;
        if (card.length() == 2) {
            typeSymbol = card.charAt(1);
        } else {
            typeSymbol = card.charAt(2);
        }
        int type = 0;
        if (typeSymbol == 'S') {
            type = 4;
        } else if (typeSymbol == 'H') {
            type = 3;
        } else if (typeSymbol == 'D') {
            type = 2;
        } else if (typeSymbol == 'C') {
            type = 1;
        }
        return type;

    }
}
