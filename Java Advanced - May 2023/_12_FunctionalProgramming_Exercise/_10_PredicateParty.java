package _12_FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> peopleList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Party!")) {

            Predicate<String> predicate = null;

            String criteria = command.split("\\s+")[2];

            if (command.contains("StartsWith")) {
                predicate = x -> x.startsWith(criteria);
            } else if (command.contains("EndsWith")) {
                predicate = x -> x.endsWith(criteria);
            } else {
                predicate = x -> x.length() == Integer.parseInt(criteria);
            }

            if (command.contains("Remove")) {
                ArrayList<String> toRemove = new ArrayList<>();
                for (String guest : peopleList) {
                    if(predicate.test(guest)){
                        toRemove.add(guest);
                    }
                }

                peopleList.removeAll(toRemove);

            } else if (command.contains("Double")) {
                ArrayList<String> toAdd = new ArrayList<>();
                for (String guest : peopleList) {
                    if(predicate.test(guest)){
                        toAdd.add(guest);
                    }
                }

                peopleList.addAll(toAdd);
            }

            command = scanner.nextLine();
        }

        if (peopleList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(peopleList.stream().sorted()
                    .collect(Collectors.toCollection(ArrayList::new))
                    .toString()
                    .replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
