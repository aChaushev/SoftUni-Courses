package _14_DefiningClasses_Exercise._06_PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<Pokemon>> trainersMap = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            //"{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainersMap.putIfAbsent(trainerName, new ArrayList<>());
            trainersMap.get(trainerName).add(pokemon);

            input = scanner.nextLine();
        }

        List<Trainer> trainersList = trainersMap.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());


        String inputElement = scanner.nextLine();

        while (!inputElement.equals("End")) {
            for (Trainer trainer : trainersList) {
                trainer.elementExecute(inputElement);
            }

            inputElement = scanner.nextLine();
        }


        trainersList.stream()
                .sorted(Comparator.comparingInt((Trainer trainer) -> trainer.getNumberOfBadges()).reversed())
                .forEach(System.out::println);
    }
}
