package _08_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class _09_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> countriesMap = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            countriesMap.putIfAbsent(country, new LinkedHashMap<>());

            Map<String, Long> citiesMap = countriesMap.get(country);

            citiesMap.put(city, population);

            input = scanner.nextLine();
        }


        countriesMap.entrySet().stream().sorted((e1, e2) -> {
            long totalPopulationFirst = countriesMap.get(e1.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            long totalPopulationSecond = countriesMap.get(e2.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            return Long.compare(totalPopulationSecond, totalPopulationFirst);
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");

            StringBuilder builder = new StringBuilder();

            AtomicReference<Long> totalPopulation = new AtomicReference<>((long) 0);

            countriesMap.get(entry.getKey()).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> {
                        builder.append(String.format("=>%s: %d%n", e.getKey(), e.getValue()));
                        totalPopulation.updateAndGet(v -> v + e.getValue());
                    });

            System.out.printf("(total population: %s)%n", totalPopulation);
            System.out.print(builder);
        });
    }
}
