package _08_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split("\\s+")[0]);
        int m = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();

        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            firstSet.add(value);
        }

        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            secondSet.add(value);
        }

        // пърчи начин
//        Set<Integer> duplicateElements = new LinkedHashSet<>();
//        for(int number : firstSet){
//            if(secondSet.contains(number)){
//                duplicateElements.add(number);
//            }
//        }
//        duplicateElements.forEach(e -> System.out.print(e + " "));

        //втори начин
        firstSet.retainAll(secondSet);
        // retainAll -> премахва всички елементи от firstSet, които ги няма във втория
        // firstSet -> остават елементите, които ги има и във втория set
        firstSet.forEach(e -> System.out.print(e + " "));

    }
}
