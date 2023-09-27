package _07_SetsAndMapsAdvanced_Lab;

import java.util.*;

public class _07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];


            continentsMap.putIfAbsent(continent, new LinkedHashMap<>());

            Map<String, List<String>> countriesMap = continentsMap.get(continent);

            countriesMap.putIfAbsent(country, new ArrayList<>());

            List<String> citiesList = countriesMap.get(country);

            citiesList.add(city);
        }

        continentsMap.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> {
                String cities = String.join(", ", value1);
                System.out.println("  " + key1 + " -> " + cities);
            });
        });

//        continentsMap.entrySet().stream()
//                .forEach(entry -> {
//                    System.out.println(entry.getKey() + ":");
//                    entry.getValue().entrySet().stream()
//                            .forEach(innerEntry -> {
//                                String cities = String.join(", ",innerEntry.getValue());
//                                System.out.println("  " + innerEntry.getKey() + " -> " + cities);
//                            });
//                });

    }
}
