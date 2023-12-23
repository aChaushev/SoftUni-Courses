package _11_FunctionalProgramming_Lab;

import java.util.*;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isStartingWithUppercase =
                w -> Character.isUpperCase(w.charAt(0));

        List<String> listOfWords = new ArrayList<>();

        Arrays.stream(words)
                .filter(isStartingWithUppercase)  // филтъра очаква Predicate
                .forEach(w -> listOfWords.add(w));

        System.out.println(listOfWords.size());

        System.out.println(String.join(System.lineSeparator(),listOfWords));
    }
}
